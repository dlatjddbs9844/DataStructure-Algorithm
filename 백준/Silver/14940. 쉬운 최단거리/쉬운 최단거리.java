import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[] destination = new int[2];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        board = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i][j] = val;
                if(val == 2) {
                    destination[0] = j;
                    destination[1] = i;
                }
            }
        }

        bfs(destination[0], destination[1]);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    board[i][j] = -1;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[y][x] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= m || nextY >= n) {
                    continue;
                }
                if(visited[nextY][nextX] || arr[nextY][nextX] == 0) {
                    continue;
                }

                q.add(new int[] {nextX, nextY});
                visited[nextY][nextX] = true;
                board[nextY][nextX] = board[curY][curX] + 1;
            }
        }
    }
}
