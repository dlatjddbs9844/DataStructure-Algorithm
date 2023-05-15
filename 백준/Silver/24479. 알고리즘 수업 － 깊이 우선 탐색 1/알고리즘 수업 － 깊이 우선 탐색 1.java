
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] ans;
    static int idx = 1;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited= new boolean[N+1];
        ans = new int[N+1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer vertex = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(vertex.nextToken());
            int v = Integer.parseInt(vertex.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        doDFS(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) sb.append(ans[i]).append('\n');
        System.out.print(sb);

    }

    public static void doDFS(int start) {
        visited[start] = true;
        ans[start] = idx++;
        for(int v: graph[start]) {
            if(!visited[v]) {
                doDFS(v);
            }
        }
    }
}
