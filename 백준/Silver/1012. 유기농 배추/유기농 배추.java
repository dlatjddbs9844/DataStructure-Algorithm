

import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int m, n, k;
    static int cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++ ){
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken()); // 가로길이
            n = Integer.parseInt(st.nextToken()); // 세로길이
            k = Integer.parseInt(st.nextToken()); // 배추 심어져있는 위치의 개수

            graph = new int[n][m];
            visited = new boolean[n][m];
            cnt = 0;
            
            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[y][x] = 1;
            }

            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    if(!visited[j][k] && graph[j][k] == 1){
                        cnt++;
                        dfs(k,j);
                    }
                }
            }
            System.out.println(cnt);
        }

    }

    public static void dfs(int x, int y){
        visited[y][x] = true;
        for(int i = 0; i < 4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];

            if(ax >= 0 && ax < m && ay >= 0 && ay < n) {
                if(!visited[ay][ax] && graph[ay][ax] == 1) {
                    dfs(ax, ay);
                }
            }
        }


    }
}
