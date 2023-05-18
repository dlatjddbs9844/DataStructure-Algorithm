package DataStructure.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class KEdge {
    int u;
    int v;
    int w;
    KEdge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

public class KruskalAlgorithm {
    static int[] parent;
    static ArrayList<KEdge> graph;
    static int V; // the number of vertices
    static int E; // the number of edges
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        parent = new int[V];

        for(int i = 0; i < V; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.add(new KEdge(u, v, w));
        }
    }

    public static void Kruskal() {
        // sorting the edge in ascending order(minimum cost -> maximum cost)
        graph.sort(new Comparator<KEdge>() {
            @Override
            public int compare(KEdge o1, KEdge o2) {
                return o1.w - o2.w;
            }
        });

        for(int i = 0; i < E; i++) {
            KEdge edge = graph.get(i);
            if(find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
            }
        }

    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }

}
