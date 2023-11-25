
import java.io.*;
import java.util.*;

class Vertex implements Comparable<Vertex> {
    int v;
    int cost;
    Vertex(int v, int cost){
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Vertex v1){
        return this.cost - v1.cost;
    }
}

public class Main {
    static ArrayList<ArrayList<Vertex>> graph;
    static boolean[] visited;
    static int[] dist;
    static int[] prev;
    static ArrayList<Integer> route = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // Init
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        visited = new boolean[N+1];
        dist = new int[N+1];
        prev = new int[N+1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Vertex(v, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dist[start] = 0;

        dijkstra(start);

        System.out.println(dist[end]);
        int cur = end;
        while(cur != 0) {
            route.add(cur);
            cur = prev[cur];
        }

        System.out.println(route.size());
        for(int i = route.size()-1; i >= 0; i--){
            System.out.print(route.get(i) + " ");
        }

    }


    public static void dijkstra(int start){
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(start, 0));
        prev[start] = 0;

        while(!pq.isEmpty()){
            Vertex cur = pq.poll();
            int u = cur.v;

            if(!visited[u]){
                visited[u] = true;
                for(Vertex vertex : graph.get(u)){
                    int v = vertex.v;
                    int c = vertex.cost;

                    if(dist[v] > dist[u] + c){
                        dist[v] = dist[u] + c;
                        pq.add(new Vertex(v, dist[v]));
                        prev[v] = u;
                    }
                }
            }


        }
    }

}