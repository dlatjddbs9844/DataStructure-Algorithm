

import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n];
        back(n, m, 0);
        System.out.println(sb);
    }
    public static void back(int n, int m, int depth){
        if(depth == m) {
            for(int i = 0; i < arr.length; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i+1;
                back(n, m, depth+1);

                visited[i] = false;
            }
        }
    }
}
