
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0 , 0};
    static ArrayList<int[]> origin = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<int[]> wall = new ArrayList();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    origin.add(new int[] {j, i});
                } else if(map[i][j] == 0) {
                    wall.add(new int[] {j, i});
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < wall.size()-2; i++){
            int[] pos1 = wall.get(i);
            for(int j = i+1; j < wall.size() -1; j++){
                int[] pos2 = wall.get(j);
                for(int k = j+1; k < wall.size(); k++){
                    int[] pos3 = wall.get(k);
                    map[pos1[1]][pos1[0]] = 1;
                    map[pos2[1]][pos2[0]] = 1;
                    map[pos3[1]][pos3[0]] = 1;
                    ans = Math.max(ans, bfs());
                    map[pos1[1]][pos1[0]] = 0;
                    map[pos2[1]][pos2[0]] = 0;
                    map[pos3[1]][pos3[0]] = 0;
                }
            }
        }


        System.out.println(ans);

    }

    public static int bfs(){
        int[][] board = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();


        for(int i = 0; i < N; i++){
            board[i] = map[i].clone();
        }

        for(int[] pos : origin){
            q.add(pos);
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            visited[curY][curX] = true;

            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N){
                    continue;
                }
                if (visited[nextY][nextX] || board[nextY][nextX] == 1) {
                    continue;
                }

                if(board[nextY][nextX] == 0) {
                    q.add(new int[] {nextX, nextY});
                    board[nextY][nextX] = 2;
                }
            }
        }

        int ret = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == 0){
                    ret++;
                }
            }
        }

        return ret;
    }


}