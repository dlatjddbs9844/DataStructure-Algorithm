package DataStructure.Graph;

/* Topological sort
    Given a directed graph, find a total ordering of vertices s.t.
    for every arc <u, v>, u precedes v in the ordering
    A DAG(Directed Acyclic Graph) always has a topological order
*/

/* Process
    while graph != empty
    find a vertex with no incoming arcs; output and delete it
    if the graph contains a (directed) cycle, this algorithm gonna fail
*/

import java.io.*;
import java.util.*;

public class TopologicalSort {
    static int N; // The number of vertex
    static int M; // The number of edges
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        int[] incomeEdge = new int[N+1];

        // Directed graph with no cost
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // starting vertex = 1
        for(int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // Initializing Graph
        for(int i = 0; i < M; i++) {
            int u = Integer.parseInt(br.readLine());
            int v = Integer.parseInt(br.readLine());

            // Edge from vertex u to vertex v
            // then outgoing edge from vertex u
            // and incoming edge to vertex v;
            // What is important in topological sort is the number of incoming edges
            // so we don't care about outgoing edge
            graph.get(u).add(v);
            incomeEdge[v] += 1;
        }

        topologicalSort(graph, incomeEdge);
    }
    static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] incomeEdge) {
        Queue<Integer> q = new LinkedList();

        // 1. Enqueue all the vertexes which doesn't have incoming edge
        for(int i = 0; i < N+1; i++) {
            if(incomeEdge[i] == 0) {
                q.add(i);
            }
        }

        // 2. visit all the vertexes
        for(int i = 0; i < N; i++) {
            // In order of the vertexes which doesn't have incoming edges
            int u = q.remove();
            System.out.print(u + " ");

            // Visit all the vertexes adjacent from vertex u
            for(int nextV : graph.get(u)) {
                // We remove the vertex v then remove the incoming edge
                // from vertex u to nextV
                incomeEdge[nextV]--;

                // After remove the edge,
                // If there is no incoming edge,
                // enqueue
                if(incomeEdge[nextV] == 0) {
                    q.add(nextV);
                }
            }
        }
    }
}
