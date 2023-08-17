
import java.io.*;
import java.util.*;

public class Main {
    static long[][] m = {{1, 1}, {1, 0}};
    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long[][] A = {{1, 1}, {0, 0}};

        System.out.println(pow(A, N-1)[0][0]);


    }

    public static long[][] pow(long[][] A, long exp){
        if(exp == 1L || exp == 0L){
            return m;
        }
        long[][] ret = pow(A, exp / 2);
        ret = multi(ret, ret);

        if(exp % 2 != 0) {
            ret = multi(ret, m);
        }

        return ret;
    }

    public static long[][] multi(long[][] m1, long[][] m2) {
        long[][] ret = new long[2][2];

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++){
                    ret[i][j] += m1[i][k] * m2[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }

        return ret;
    }



}