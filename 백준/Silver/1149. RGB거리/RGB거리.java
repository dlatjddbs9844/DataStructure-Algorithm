
import javax.swing.*;
import java.util.*;
import java.io.*;


public class Main {

    static int[][] dp;
    static int[][] cost;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        cost= new int[n+1][3];
        dp = new int[n+1][3];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            // 빨 초 파
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];

        int ans = Math.min(cost(n, 0), Math.min(cost(n, 1), cost(n, 2)));

        System.out.println(ans);
    }

    public static int cost(int n, int color){
         if(dp[n][color] == 0) {
             if (color == 0){
                 dp[n][0] = cost[n][0] + Math.min(cost(n-1, 1), cost(n-1, 2));
             } else if (color == 1){
                 dp[n][1] = cost[n][1] + Math.min(cost(n-1, 0), cost(n-1, 2));
             } else{
                dp[n][2] = cost[n][2] + Math.min(cost(n-1, 0), cost(n-1, 1));
             }
         }

         return dp[n][color];
    }
}
