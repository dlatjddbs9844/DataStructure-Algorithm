import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int ans = 0;

        for(int i = n-1; i >= 0; i--){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int j = 0; j < n; j++){
            int p = arr[j];
            if(k / p != 0) {
                ans += (k/p);
                k %= p;
            }
        }

        System.out.println(ans);
    }
}