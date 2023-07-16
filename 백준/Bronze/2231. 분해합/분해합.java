import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = n;
        for(int i = 1; i < n; i++) {
            int sum = 0;
            String s = Integer.toString(i);
            for(int j = 0; j < s.length(); j++) {
                sum += Integer.parseInt(Character.toString(s.charAt(j)));
            }
            if(i + sum == n){
                if(i < m){
                    m = i;
                }
            }
        }

        if(m == n) {
            System.out.println(0);
        }else{
            System.out.println(m);
        }

    }



}