
import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static boolean[] visited;
    static char[][] board;
    static int maxD = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // Init
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[26];

        for(int i = 0; i < R; i++){
            char[] c = br.readLine().toCharArray();
            for(int j = 0; j < C; j++){
                board[i][j] = c[j];
            }
        }

        dfs(0, 0, 0);
        System.out.println(maxD+1);
    }

    public static void dfs(int x, int y, int len){
        if(len > maxD){
            maxD = len;
        }

        char alphabet = board[y][x];
        visited[(int)alphabet - 65] = true;
        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];


            if(nextX < 0 || nextY < 0 || nextX >= C || nextY >= R){
                continue;
            }
            int tmp = board[nextY][nextX]-65;
            if(visited[tmp]){
                continue;
            }
            dfs(nextX, nextY, len+1);
            visited[tmp] = false;
        }
    }

}