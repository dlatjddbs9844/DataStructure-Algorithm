import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(combi(n,k));

    }

    public static int combi(int n, int k) {
        if(n == k || k == 0) {
            return 1;
        }
        int r1 = combi(n-1, k);
        int r2 = combi(n-1, k-1);
        return r1 + r2;
    }

}