import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int cnt;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cnt = 0;
        arr = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < str.length; j++){
                arr[i][j+1] = Integer.parseInt(str[j]);
            }
        }
        visited[1][1] = true;
        bfs(1, 1);

    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX <= 0 || nextY <= 0 || nextX > m || nextY > n) {
                    continue;
                }
                if(visited[nextY][nextX] || arr[nextY][nextX] == 0) {
                    continue;
                }

                q.add(new int[] {nextX, nextY});
                arr[nextY][nextX] = arr[curY][curX] + 1;
                visited[nextY][nextX] = true;
            }
        }

        System.out.println(arr[n][m]);


    }

}
