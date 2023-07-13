import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        for(int i = start; i <= end; i++) {
            if(isPrime(i)) {
                System.out.println(i);
            }
        }
    }
    public static boolean isPrime(int n) {
        if(n <= 1) return false;
        // 짝수 제외
        if(n % 2 == 0) {
            if (n == 2) return true;
            else return false;
        }

        int sqrt = (int)Math.sqrt(n);
        for(int i = 3; i <= sqrt; i+=2) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
