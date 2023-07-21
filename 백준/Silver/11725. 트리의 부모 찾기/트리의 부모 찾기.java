
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class Main {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int idx = 2;
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        graph = new ArrayList<>();
        visited = new boolean[n+1];
        for(int i = 0 ; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1);

        for(int i = 2; i < parent.length; i++){
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int u){
        visited[u] = true;

        for(int v : graph.get(u)){
            if(!visited[v]){
                parent[v] = u;
                dfs(v);
            }
        }
    }
}
