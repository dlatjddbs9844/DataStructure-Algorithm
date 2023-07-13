import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[8001];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int median = 5000;
        int mode = 5000;

        for(int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            sum += val;
            arr[val+4000]++;
            if(max < val) {
                max = val;
            }
            if(min > val) {
                min = val;
            }
        }

        int cnt = 0;
        int freq = 0;
        boolean flag = false;

        for(int i = min + 4000; i <= max + 4000; i++) {
            if(arr[i] > 0) {
                if(cnt < (n+1) / 2) {
                    median = i - 4000;
                    cnt += arr[i];
                }

                if(freq < arr[i]) {
                    freq = arr[i];
                    mode = i - 4000;
                    flag = true;
                }
                else if (freq == arr[i] && flag == true) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }

        System.out.println((int)Math.round((double)sum / n));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(max-min);
    }
}