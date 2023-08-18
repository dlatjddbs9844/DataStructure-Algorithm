import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static int[] parent;
    static boolean[] know;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // Init
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        know = new boolean[N+1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for(int i = 0; i < K; i++){
            know[Integer.parseInt(st.nextToken())] = true;
        }

        ArrayList<Integer>[] parties = new ArrayList[M];
        for(int i = 0; i < M; i++){
            parties[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            parties[i].add(x);
            for(int j = 0; j < n-1; j++){
                int y = Integer.parseInt(st.nextToken());
                parties[i].add(y);
                union(x, y);
            }
        }

        for(int i = 1; i <= N; i++){
            if(know[i]){
                know[find(i)] = true;
            }
        }

        int ans = 0;
        for(int i = 0; i < M; i++){
            if(!know[find(parties[i].get(0))]) ans++;
        }

        System.out.println(ans);
    }

    public static int find(int i){
        if(parent[i] == i){
            return i;
        }

        return parent[i] = find(parent[i]);
    }

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            if(x <= y) parent[y] = x;
            else parent[x] = y;
            return true;
        }

        return false;
    }
}