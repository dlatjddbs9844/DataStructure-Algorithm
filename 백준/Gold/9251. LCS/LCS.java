
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Init
        String[] s1 = br.readLine().split("");
        String[] s2 = br.readLine().split("");
        int[][] LCS = new int[s2.length+1][s1.length+1];

        for(int i = 0; i <= s2.length; i++){
            for(int j = 0; j <= s1.length; j++){
                if(i == 0 || j == 0) {
                    LCS[i][j] = 0;
                } else if(s2[i-1].equals(s1[j-1])){
                    LCS[i][j] = LCS[i-1][j-1]+1;
                } else{
                    LCS[i][j] = Math.max(LCS[i][j-1], LCS[i-1][j]);
                }
            }
        }

        System.out.println(LCS[s2.length][s1.length]);
    }
}