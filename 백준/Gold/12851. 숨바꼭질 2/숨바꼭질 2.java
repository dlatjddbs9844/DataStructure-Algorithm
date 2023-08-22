
import java.awt.*;
import java.io.*;
import java.util.*;


public class Main {
    static int N, K;
    static int minTime = 999999999;
    static int[] time = new int[100001];
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N >= K) {
            System.out.println((N-K));
            System.out.println(1);
            return;
        }

        bfs();

        System.out.println(minTime);
        System.out.println(cnt);
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        time[N] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();


            if(minTime < time[cur]) return;

            for(int i = 0; i < 3; i++){
                int next;
                if(i == 0) next = cur + 1;
                else if(i == 1) next = cur - 1;
                else next = cur * 2;

                if(next < 0 || next > 100000) continue;

                if(next == K){
                    minTime = time[cur];
                    cnt++;
                }

                if(time[next] == 0 || time[next] == time[cur]+1){
                    q.add(next);
                    time[next] = time[cur] + 1;
                }

            }
        }
    }
}