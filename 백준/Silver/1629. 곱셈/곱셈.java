
import java.io.*;
import java.util.*;

public class Main {
    static long c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(modulo(a, b));
    }

    public static long modulo(long a, long b){
        if(b == 1) return a % c;

        long tmp = modulo(a, b / 2);

        // 홀수일 때
        if(b % 2 == 1) {
           return ((tmp * tmp % c)) * a % c;
        }

        return (tmp%c)*(tmp%c) % c;
    }


}