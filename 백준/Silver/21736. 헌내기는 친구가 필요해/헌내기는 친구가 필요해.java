

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] board;
    static boolean[][] visited;
    static int cnt = 0;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j < m; j++){
                board[i][j] = ch[j];
                if(ch[j] == 'I'){
                    q.add(new int[] {j, i});
                }
            }
        }
        bfs();
        if(cnt == 0){
            System.out.println("TT");
        } else{
            System.out.println(cnt);
        }
    }


    public static void bfs(){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= m || nextY >= n){
                    continue;
                }
                if(visited[nextY][nextX] || board[nextY][nextX] == 'X'){
                    continue;
                }

                if(board[nextY][nextX] == 'P'){
                    cnt++;
                }

                visited[nextY][nextX] = true;
                q.add(new int[] {nextX, nextY});
            }
        }
    }



}