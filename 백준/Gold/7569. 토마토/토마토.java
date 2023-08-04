import java.io.*;
import java.util.*;

public class Main {
    static int[][][] tomato;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int m, n, h;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        tomato = new int[h][n][m];
        visited = new boolean[h][n][m];

        for(int height = 0; height < h; height++){
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < m; j++){
                    int val = Integer.parseInt(st.nextToken());
                    if(val == 1){
                        q.add(new int[] {j, i, height});
                        visited[height][i][j] = true;
                    }
                    tomato[height][i][j] = val;
                }
            }
        }

        int ans = bfs();
        if(isZero()){
            System.out.println(-1);
            return;
        }else{
            if(ans != 0){
                System.out.println(ans-1);
                return;
            }
            System.out.println(ans);
        }
//        for(int height = 0; height < h; height++){
//            for(int i = 0; i < n; i++) {
//                for(int j = 0; j < m; j++){
//                    System.out.print(tomato[height][i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

    }

    public static int bfs(){
        int ans = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curZ = cur[2];

            for(int i = 0; i < 6; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                int nextZ = curZ + dz[i];
                if(nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= m || nextY >= n || nextZ >= h) {
                    continue;
                }
                if(visited[nextZ][nextY][nextX] || tomato[nextZ][nextY][nextX] == -1) {
                    continue;
                }

                visited[nextZ][nextY][nextX] = true;
                ans = tomato[curZ][curY][curX] + 1;
                tomato[nextZ][nextY][nextX] = tomato[curZ][curY][curX] + 1;
                q.add(new int[] {nextX, nextY, nextZ});
            }
        }
        return ans;
    }
    public static boolean isZero() {
        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    if(tomato[i][j][k] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}