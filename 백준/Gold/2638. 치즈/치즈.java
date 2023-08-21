
import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<int[]> cheeseList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) cheeseList.add(new int[] {j, i});
                board[i][j] = val;
            }
        }

        int cnt = 0;
        while(!cheeseList.isEmpty()){
            visited = new boolean[N][M];
            bfs();
            melting();
            cnt++;
        }
        
        System.out.println(cnt);
    }

    // 외부 공기임을 판별
    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        visited[0][0] = true;
        board[0][0] = 2;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N){
                    continue;
                }
                if(visited[nextY][nextX] || board[nextY][nextX] == 1){
                    continue;
                }

                board[nextY][nextX] = 2;
                q.add(new int[] {nextX, nextY});
                visited[nextY][nextX] = true;
            }
        }
    }

    public static void melting(){
        for(int i = 0; i < cheeseList.size(); i++){
            int x = cheeseList.get(i)[0];
            int y = cheeseList.get(i)[1];

            int numConta = 0;
            for(int j = 0; j < 4; j++){
                int nextX = x + dx[j];
                int nextY = y + dy[j];

                if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N){
                    continue;
                }
                if(board[nextY][nextX] == 2){
                    numConta++;
                }
            }

            if(numConta >= 2){
                board[y][x] = 0;
                cheeseList.remove(i);
                i--;
            }
        }
    }



}