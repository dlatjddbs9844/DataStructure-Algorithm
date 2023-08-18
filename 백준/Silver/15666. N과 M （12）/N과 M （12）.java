
import java.io.*;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] given;
    static boolean[] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        given = new int[N];
        arr = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            given[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(given);
        back(0);
        System.out.println(sb);
    }

    public static void back(int depth){
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        int before = 0;
        for(int i = 0; i < N; i++){
            if(before != given[i]){
                if(depth == 0) {
                    arr[depth] = given[i];
                    before = given[i];
                    back(depth+1);
                } else{
                    if(arr[depth-1] <= given[i]){
                        arr[depth] = given[i];
                        before = given[i];
                        back(depth+1);
                    }
                }

            }
        }
    }

}