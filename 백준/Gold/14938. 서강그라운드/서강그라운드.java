
import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int v;
    int weight;
    Node(int v, int weight){
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o1){
        return this.weight - o1.weight;
    }
}

public class Main {
    static int V, R, E;
    static int[] item;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        item = new int[V+1];

        for(int i = 1; i <= V; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList<>();

        for(int i = 0; i <= V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        dist = new int[V+1];
        visited = new boolean[V+1];

        int ans = 0;
        for(int i = 1; i <= V; i++){
            ans = Math.max(ans, dijkstra(i));
        }

        System.out.println(ans);
    }

    public static int dijkstra(int start){
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int u = cur.v;
            visited[u] = true;

            for(Node node : graph.get(u)){
                int v = node.v;
                int w = node.weight;
                if(!visited[v] && dist[v] > dist[u] + w){
                    dist[v] = dist[u] + w;
                    pq.add(new Node(v, dist[u] + w));
                }
            }
        }

        int ret = 0;

        for(int i = 1; i <= V; i++){
            if(dist[i] <= R){
                ret += item[i];
            }
        }

        return ret;
    }


}