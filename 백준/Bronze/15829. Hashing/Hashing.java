import java.util.*;
import java.io.*;


public class Main{
    static final int R = 31;
    static final int M = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(hash(str));
    }

    public static int hash(String str) {
        int ans = 0;
        char[] arr = new char[str.length()];

        for(int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        for(int i = 0; i < str.length(); i++){
            int val = ((int)arr[i]) - 96;
            ans += val*(Math.pow(R, i));
        }

        return ans % M;
    }



}