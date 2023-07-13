import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] coord = new int[N][M];
        int time1 = 0;
        int time2 = 0;
        boolean flag = false;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                coord[i][j] = val;
                if(max <= val) {
                    max = val;
                }
                if(min >= val) {
                    min = val;
                }
            }
        }

        int time = Integer.MAX_VALUE;
        int high = 0;
        for(int i = min; i <= max; i++) {
            int count = 0;
            int block = B;
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    int val = coord[j][k];
                    if(i < val){
                        count += 2*(val-i);
                        block += val-i;
                    }
                    else {
                        count += i - val;
                        block -= i - val;
                    }
                }
            }
            if(block < 0) break;
            if(time >= count) {
                time = count;
                high = i;
            }
        }

        System.out.println(time + " " + high);



    }
}