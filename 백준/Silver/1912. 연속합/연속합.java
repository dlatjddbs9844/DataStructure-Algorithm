
import java.util.*;
import java.io.*;

public class Main {
    static Integer[] dp;
    static int[] arr;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        dp = new Integer[n];
        arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        max = arr[0];
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);

            max = Math.max(dp[i], max);
        }

        System.out.println(max);


    }

}
