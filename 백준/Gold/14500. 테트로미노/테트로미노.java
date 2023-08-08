
import java.io.*;
import java.util.*;


public class Main {
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int n, m;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited[i][j] = true;
                dfs(j, i, board[i][j],1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);

    }
    public static void dfs(int x, int y, int sum, int cnt){
        if(cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            int curX = x + dx[i];
            int curY = y + dy[i];

            if(curX < 0 || curY < 0 || curX >= m || curY >= n){
                continue;
            }
            if(visited[curY][curX]) {
                continue;
            }

            if(cnt == 2){
                visited[curY][curX] = true;
                dfs(x, y, sum+board[curY][curX], cnt+1);
                visited[curY][curX] = true;
            }

            visited[curY][curX] = true;
            dfs(curX, curY, sum+board[curY][curX], cnt+1);
            visited[curY][curX] = false;
        }

    }

}