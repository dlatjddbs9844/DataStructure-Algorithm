import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int c = gcd(a, b);
        int d = lcm(a, b, c);

        System.out.println(c);
        System.out.println(d);
    }

    public static int gcd(int a, int b) {
        int tmp, n;
        if(a < b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        while(b != 0) {
            n = a % b;
            a = b;
            b = n;
        }
        return a;
    }

    public static int lcm(int a, int b, int gcd) {
        return (a*b)/gcd;
    }
}