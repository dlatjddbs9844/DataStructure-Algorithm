
import java.io.*;
import java.util.*;


public class Main {
    static int R, C, T;
    static int[][] house;
    static int[][] tmp;
    static int[] cleaner = new int[2];
    static Queue<int[]> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        house = new int[R][C];
        int cleanerIdx = 0;
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                house[i][j] = Integer.parseInt(st.nextToken());
                if(house[i][j] == -1){
                    cleaner[cleanerIdx++] = i;
                }
            }
        }

        for(int i = 0; i < T; i++){
            checkDust();
            diffusion();
        }

        System.out.println(getSum());
    }

    public static void checkDust(){
        q = new LinkedList<>();

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(house[i][j] == -1 || house[i][j] == 0) continue;;
                q.add(new int[]{i, j});
            }
        }
    }
    public static void diffusion(){
        tmp = new int[R][C];

        // 미세먼지 확산
        while(!q.isEmpty()){
            int[] dustPos = q.poll();
            int curX = dustPos[1];
            int curY = dustPos[0];
            int dustAmount = house[curY][curX];
            int nextAmount = dustAmount / 5;
            int cnt = 0;

            for(int j = 0; j < 4; j++){
                int nextX = curX + dx[j];
                int nextY = curY + dy[j];

                if(nextX < 0 || nextY < 0 || nextX >= C || nextY >= R){
                    continue;
                }
                if(house[nextY][nextX] == -1) {
                    continue;
                }

                tmp[nextY][nextX] += nextAmount;
                cnt++;
            }

            house[curY][curX] = dustAmount - (dustAmount/5)*cnt;
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                house[i][j] += tmp[i][j];
            }
        }

        // 공기청정기에 의해 확산
        int upper = cleaner[0];
        int lower = cleaner[1];

        // 반시계회전
        counterClock(upper);
        clock(lower);
    }

    public static void counterClock(int start){
        for(int i = 0; i < R; i++){
            tmp[i] = house[i].clone();
        }
        tmp[cleaner[0]][0] = 0;
        tmp[cleaner[1]][0] = 0;


        if(start != 0) {
            for(int i = 0; i < start-1; i++){
                house[i+1][0] = tmp[i][0];
            }
            for(int i = 1; i < C; i++){
                house[0][i-1] = tmp[0][i];
            }
            for(int i = 1; i <= start; i++){
                house[i-1][C-1] = tmp[i][C-1];
            }
        }

        for(int i = 0; i < C-1; i++){
            house[start][i+1] = tmp[start][i];
        }

    }

    public static void clock(int start){
        for(int i = 0; i < R; i++){
            tmp[i] = house[i].clone();
        }
        tmp[cleaner[0]][0] = 0;
        tmp[cleaner[1]][0] = 0;


        if(start != R-1) {
            for(int i = R-1; i > start+1; i--){
                house[i-1][0] = tmp[i][0];
            }
            for(int i = 1; i < C; i++){
                house[R-1][i-1] = tmp[R-1][i];
            }
            for(int i = start; i < R-1; i++){
                house[i+1][C-1] = tmp[i][C-1];
            }
        }

        for(int i = 0; i < C-1; i++){
            house[start][i+1] = tmp[start][i];
        }

    }

    public static int getSum(){
        int cnt = 0;

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(house[i][j] != -1) {
                    cnt += house[i][j];
                }
            }
        }

        return cnt;
    }

}