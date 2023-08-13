
import java.awt.*;
import java.io.*;
import java.util.*;

class Cord {
    int x;
    int y;
    int cnt;
    boolean destroyed;
    Cord(int x, int y, int cnt, boolean destroyed){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.destroyed = destroyed;
    }
}

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Init
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(str[j]);
            }
        }

        Queue<Cord> q = new LinkedList<>();
        q.add(new Cord(0, 0, 1, false));

        while(!q.isEmpty()){
            Cord cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            if(curX == M-1 && curY == N-1){
                System.out.println(cur.cnt);
                return;
            }
            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N){
                    continue;
                }

                if(board[nextY][nextX] == 0){
                    if(!cur.destroyed && !visited[nextY][nextX][0]){
                        q.add(new Cord(nextX, nextY, cur.cnt+1, false));
                        visited[nextY][nextX][0] = true;
                    } else if(cur.destroyed && !visited[nextY][nextX][1]){
                        q.add(new Cord(nextX, nextY, cur.cnt+1, true));
                        visited[nextY][nextX][1] = true;
                    }
                } else {
                    if(!cur.destroyed && !visited[nextY][nextX][1]){
                        q.add(new Cord(nextX, nextY, cur.cnt + 1, true));
                        visited[nextY][nextX][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }


}