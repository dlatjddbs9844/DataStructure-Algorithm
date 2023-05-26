
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Node{
    int u;
    int v;
    Node(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

public class Main {
    static int[] dfn;
    static int order = 1;
    static ArrayList<Node> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer init = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(init.nextToken());
        int E = Integer.parseInt(init.nextToken());

        dfn = new int[V+1];
        answer = new ArrayList<>();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= V; i++) {
            if(dfn[i] == 0){
                findCutEdge(i, 0, graph);
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

    public static int findCutEdge(int u, int parent, ArrayList<ArrayList<Integer>> graph) {
        dfn[u] = order++;
        int ret = dfn[u];

        for(int v : graph.get(u)){
            if(v == parent) continue;
            if(dfn[v] == 0){
                int low = findCutEdge(v, u, graph);

                // No back edge from u's descendant
                if(low > dfn[u]){
                    if(u > v) {
                        answer.add(new Node(v, u));
                    }
                    else{
                        answer.add(new Node(u, v));
                    }
                }
                ret = Math.min(ret, low);
            }
            // we are seeing back edge
            // during the dfs
            // if there is no back edge -> low will equal to its dfn
            // if there is back edge -> low will be the smallest dfn that
            // can be reached by bback edge
            else{
                ret = Math.min(ret, dfn[v]);
            }
        }

        return ret;
    }
}
