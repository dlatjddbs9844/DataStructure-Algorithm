
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int[] cur = null;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                if(val == 9){
                    cur = new int[] {j, i};
                    map[i][j] = 0;
                }
            }
        }

        int size = 2;
        int time = 0; //  총 거리
        int tot = 0; // 먹은 물고기 수

        while(true){
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[1] != o2[1]) ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]));
            boolean[][] visited = new boolean[N][N];
            pq.add(new int[] {cur[0], cur[1], 0});
            visited[cur[1]][cur[0]] = true;
            boolean isEat = false;

            while(!pq.isEmpty()){
                cur = pq.poll();
                int curX = cur[0];
                int curY = cur[1];
                int curTime = cur[2];

                if(map[curY][curX] != 0 && map[curY][curX] < size){
                    map[curY][curX] = 0;
                    tot++;
                    time += curTime;
                    isEat = true;
                    break;
                }

                for(int i = 0; i < 4; i++){
                    int nextX = curX + dx[i];
                    int nextY = curY + dy[i];

                    if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                        continue;
                    }
                    if(visited[nextY][nextX] || map[nextY][nextX] > size){
                        continue;
                    }

                    pq.add(new int[] {nextX, nextY, cur[2] + 1});
                    visited[nextY][nextX] = true;
                }
            }

            if (!isEat){
                break;
            }
            if (size == tot){
                size++;
                tot = 0;
            }

        }

        System.out.println(time);




    }


}