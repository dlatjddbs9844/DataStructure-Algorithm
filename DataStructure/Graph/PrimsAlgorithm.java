package DataStructure.Graph;

import java.util.*;
import java.io.*;

/* Let T be a singleton graph of an arbitrary vertex in G
     Repeat the following |V|-1 times:
      Let e=(u,v) be the minimum cost edge btw V(T) and V(G)\V(T),
      where u in V(T) and v in V(G)\V(T)
     if such e does not exist, G is disconnected
     Add v and e to T
*/
public class PrimsAlgorithm {
    static ArrayList<ArrayList<Edge>> graph;
    static int answer = 0;
    static boolean[] visited;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int V = Integer.parseInt(st.nextToken()); // Number of vertex
        final int E = Integer.parseInt(st.nextToken()); // Number of vertex

        visited = new boolean[V+1];
        graph = new ArrayList<>();
        pq = new PriorityQueue<>();

        for(int i = 0; i < V+1; i++) {
            graph.add(new ArrayList<>());
        }

        // Make graph which is composed by e=(u,v) and cost w(e)
        for(int i = 0; i < E; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(input.nextToken());
            int v = Integer.parseInt(input.nextToken());
            int w = Integer.parseInt(input.nextToken());

            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        // Starting point : vertex 1
        pq.add(new Edge(1, 0));

        while(!pq.isEmpty()){
            // At first time, this must contain starting point
            Edge edge = pq.poll();
            int v = edge.v;
            int cost = edge.cost;

            // if v is already visited, we don't need to check again.
            if(visited[v]) continue;

            visited[v] = true;
            // answer will be the final MST's total cost
            answer += cost;
            // visit all the adjacent vertex from vertex v
            for(int i = 0; i < graph.get(v).size(); i++) {
                Edge e = graph.get(v).get(i);
                // if all the adjacent vertex have not been visited
                // add it to priority queue
                // priority queue will automatically enumerate it in ascending order of edge cost
                // then this algorithm cannot help connecting u and v (e=(u,v) be the minimum cost edge btw V(T) and V(G)\V(T))
                if(!visited[e.v]) {
                    pq.add(e);
                }
            }
        }


        System.out.println(answer);

    }
}
