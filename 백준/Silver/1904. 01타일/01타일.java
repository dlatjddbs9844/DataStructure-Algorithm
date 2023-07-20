
import java.io.*;

public class Main {
    static Integer dp[] = new Integer[1000001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(ans(n));
    }

    public static int ans(int n){
        if(dp[n] == null) {
            dp[n] = (ans(n-1) + ans(n-2))%15746;
        }

        return dp[n];
    }
}
