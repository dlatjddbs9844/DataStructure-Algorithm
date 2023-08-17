
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        matrix = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] ans = pow(matrix, B);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(Integer.toString(ans[i][j])).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);


    }

    public static int[][] pow(int[][] m, long exp){
        if(exp == 1L){
            return m;
        }

        int[][] ret = pow(m, exp / 2);
        ret = multi(ret, ret);

        if(exp % 2 != 0) {
            ret = multi(ret, matrix);
        }

        return ret;
    }

    public static int[][] multi(int[][] m1, int[][] m2) {
        int[][] ret = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    ret[i][j] += m1[i][k] * m2[k][j];
                    ret[i][j] %= 1000;
                }
            }
        }

        return ret;
    }



}