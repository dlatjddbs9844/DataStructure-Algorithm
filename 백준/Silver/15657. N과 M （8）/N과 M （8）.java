
import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] given;
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // Init
        st = new StringTokenizer(br.readLine());
        // n개 중에서 m개를 선택

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        given = new int[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            given[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(given);

        back(0);
        System.out.println(sb);
    }

    public static void back(int depth){
        if(depth == M) {
            for(int i = 0; i < M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < N; i++){
            if(depth == 0) {
                arr[depth] = given[i];
                back(depth+1);
            }
            else if (arr[depth-1] <= given[i]){
                arr[depth] = given[i];
                back(depth+1);
            }
        }
    }
}