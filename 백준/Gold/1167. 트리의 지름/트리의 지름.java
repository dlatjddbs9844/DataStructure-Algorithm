
import java.io.*;
import java.util.*;

class Node{
    int v;
    int distance;
    Node(int v, int distance){
        this.v = v;
        this.distance = distance;
    }
}

public class Main {
    static ArrayList<ArrayList<Node>> tree;
    static boolean[] visited;
    static int maxD = 0;
    static int node = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for(int i = 0; i <= V; i++){
            tree.add(new ArrayList<>());
        }
        for(int i = 0; i < V; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while(true){
                int v = Integer.parseInt(st.nextToken());
                if(v == -1) {
                    break;
                }
                int d = Integer.parseInt(st.nextToken());

                tree.get(u).add(new Node(v, d));
                tree.get(v).add(new Node(u, d));
            }
        }

        visited = new boolean[V+1];
        dfs(1, 0);

        visited = new boolean[V+1];
        dfs(node, 0);

        System.out.print(maxD);

    }

    public static void dfs(int u, int d){
        if(maxD < d) {
            maxD = d;
            node = u;
        }
        visited[u] = true;
        for(Node node : tree.get(u)){
            int v = node.v;
            int cost = node.distance;
            if(!visited[v]){
                dfs(v, d + cost);
            }
        }


    }
}