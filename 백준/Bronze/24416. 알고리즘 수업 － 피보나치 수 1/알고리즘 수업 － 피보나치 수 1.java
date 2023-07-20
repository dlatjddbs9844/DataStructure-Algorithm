import java.io.*;
import java.util.*;

public class Main {
    static int[] dp = new int[41];
    static int cnt = 0;
    static int dpCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fib(n);
        fibonacci(n);
        System.out.print(cnt+ " ");
        System.out.println(dpCnt);
    }

    public static int fib(int n){
        if(n == 1 || n == 2) {
            cnt++;
            return 1;
        }

        return fib(n-1)+fib(n-2);
    }
    public static int fibonacci(int n){
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dpCnt++;
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
