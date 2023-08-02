import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[][] arr;
    static int cnt = 0;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt("" + str.charAt(j));
            }
        }


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    result.add(bfs(j, i));
                    cnt++;
                }
            }
        }
        sb.append(cnt).append('\n');
        Collections.sort(result);
        for(int i = 0; i < cnt; i++) {
            sb.append(result.get(i)).append('\n');
        }
        System.out.println(sb);
    }

    public static int bfs(int x, int y) {
        int num = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[y][x] = true;

        while(!q.isEmpty()) {
            num++;
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n){
                    continue;
                }
                if(visited[nextY][nextX] || arr[nextY][nextX] == 0) {
                    continue;
                }
                visited[nextY][nextX] = true;
                q.add(new int[] {nextX, nextY});
            }
        }

        return num;
    }
}