import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList();
        int[] incomeEdges;

        StringTokenizer init = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());

        incomeEdges = new int[N+1];

        for(int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            incomeEdges[v]++;
        }

        for(int i = 1; i < N+1; i++) {
            if(incomeEdges[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");

            for(int v : graph.get(u)){
                incomeEdges[v]--;
                if(incomeEdges[v] == 0) {
                    q.add(v);
                }
            }
        }
    }
}
