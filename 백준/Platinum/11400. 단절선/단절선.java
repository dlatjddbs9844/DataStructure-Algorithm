import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class AdjListNode{
    int v;
    int order;
    AdjListNode next;

    AdjListNode(int v, int order) {
        this.v = v;
        this.order = order;
        this.next = null;
    }
}
class AdjList{
    AdjListNode first;
    AdjListNode last;

    public AdjList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }
    public void insertAtEnd(int v, int order) {
        AdjListNode newNode = new AdjListNode(v, order);
        if(isEmpty()) {
            first = last = newNode;
        }
        else {
            last.next = newNode;
            last = newNode;
        }
    }
}
class Node{
    int u;
    int v;
    Node(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

public class Main {
    static boolean[] visited;
    static int[] dfn;
    static int[] low;
    static int order = 1;
    static AdjList[] graph;
    static ArrayList<Node> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer init = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(init.nextToken());
        int E = Integer.parseInt(init.nextToken());

        dfn = new int[V+1];
        low = new int[V+1];
        visited = new boolean[V+1];
        answer = new ArrayList<>();
        graph = new AdjList[V+1];

        for(int i = 0 ; i <= V; i++) {
            graph[i] = new AdjList();
        }

        for(int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].insertAtEnd(v, i);
            graph[v].insertAtEnd(u, i);
        }

        for (int i = 1; i <= V; i++) {
            if(dfn[i] == 0){
                findCutEdge(i, 0);
            }
        }

        Collections.sort(answer, (a1, a2) -> (a1.u == a2.u) ? a1.v - a2.v : a1.u - a2.u);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size() + "\n"); // 단절선의 개수

        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i).u + " " + answer.get(i).v + "\n"); // 단절선의 목록
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void findCutEdge(int u, int parent) {
        visited[u] = true;
        dfn[u] = low[u] = order++;

        for(AdjListNode cur = graph[u].first; cur != null; cur = cur.next){
            if(cur.v == parent) continue;
            if(!visited[cur.v]){
                findCutEdge(cur.v, u);
                low[u] = (low[cur.v] > low[u]) ? low[u] : low[cur.v];
                // No back edge from u's descendant
                if(low[cur.v] > dfn[u]){
                    if(u > cur.v) {
                        answer.add(new Node(cur.v, u));
                    }
                    else{
                        answer.add(new Node(u, cur.v));
                    }
                }
            }
            // we are seeing back edge
            // during the dfs
            // if there is no back edge -> low will equal to its dfn
            // if there is back edge -> low will be the smallest dfn that
            // can be reached by bback edge
            else{
                low[u] = (low[u] > dfn[cur.v]) ? dfn[cur.v] : low[u];
            }
        }
    }
}