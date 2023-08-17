
import java.io.*;
import java.util.*;

class Node{
    int v;
    int weight;
    Node(int v, int weight){
        this.v = v;
        this.weight = weight;
    }
}
public class Main {
    static final int INF = 987654321;
    static int[] dist;
    static int V, E, W;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        while(TC --> 0){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[V+1];
            graph = new ArrayList<>();
            for(int i = 0; i <= V; i++){
                graph.add(new ArrayList<>());
            }
            for(int i = 0; i < E + W; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                if(i < E) {
                    graph.get(u).add(new Node(v, w));
                    graph.get(v).add(new Node(u, w));
                } else{
                    graph.get(u).add(new Node(v, -w));
                }
            }

            boolean isExist = false;
            for(int i = 1; i <= V; i++){
                if(bellmanFord(i)){
                    isExist = true;
                    sb.append("YES").append('\n');
                    break;
                }
            }

            if(!isExist){
                sb.append("NO").append('\n');
            }
        }
        System.out.println(sb);

    }

    public static boolean bellmanFord(int start){
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean isUpdated = false;

        for(int i = 1; i < V; i++){
            isUpdated = false;
            for(int j = 1; j <= V; j++){
                for(Node node : graph.get(j)){
                    if(dist[j] != INF && dist[node.v] > dist[j] + node.weight){
                        dist[node.v] = dist[j] + node.weight;
                        isUpdated = true;
                    }
                }
            }
            // 음수 순환 X
            if(!isUpdated){
                break;
            }
        }
        if(isUpdated){
            for(int i = 1; i <= V; i++){
                for(Node node : graph.get(i)){
                    if(dist[i] != INF && dist[node.v] > dist[i] + node.weight){
                        dist[node.v] = dist[i] + node.weight;
                        return true;
                    }
                }
            }
        }

        return false;

    }


}