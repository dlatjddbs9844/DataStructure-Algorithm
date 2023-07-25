import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n+1];
        dp = new int[n+1];
        dp[1] = 1;
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 2; i <= n; i++){
            int val = 0;
            for(int j = 1; j < i; j++){
                if(arr[j] < arr[i]){
                    if(val < dp[j]) val = dp[j];
                }
            }
            dp[i] = val+1;
        }

        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(dp[i] > ans) ans = dp[i];
        }
        System.out.println(ans);
    }
}
