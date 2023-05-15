import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    int v;
    double cost;
    Edge(int v, double cost) {
        this.v = v;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge e) {
        return Double.compare(this.cost, e.cost);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[N];

        double[] xcord = new double[N+1];
        double[] ycord = new double[N+1];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            xcord[i] = x;
            ycord[i] = y;

            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++) {

            for(int j = i+1; j < N; j++) {
                double xcordsub = xcord[i] - xcord[j];
                double ycordsub = ycord[i] - ycord[j];
                graph[i].add(new Edge(j, Math.sqrt(Math.pow(xcordsub, 2) + Math.pow(ycordsub, 2))));
                graph[j].add(new Edge(i, Math.sqrt(Math.pow(xcordsub, 2) + Math.pow(ycordsub, 2))));
            }
        }
        System.out.printf("%.2f", prim(graph, N));
        br.close();

    }

    public static double prim(ArrayList<Edge>[] graph, int N) {
        double answer = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N];

        pq.add(new Edge(0, 0));

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int v = edge.v;
            double cost = edge.cost;

            if(visit[v]) continue;

            visit[v] = true;
            answer += cost;

            for(int i = 0; i < graph[v].size(); i++) {
                Edge e = graph[v].get(i);
                if(!visit[e.v]){
                    pq.add(e);
                }
            }
        }

        return answer;
    }
}
