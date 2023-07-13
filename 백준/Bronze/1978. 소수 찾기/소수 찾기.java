import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] notPrime = new boolean[1001];
        notPrime = prime(notPrime);
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            if (!notPrime[Integer.parseInt(st.nextToken())]){
                cnt++;
            }
        }

        System.out.println(cnt);

    }
    public static boolean[] prime(boolean[] notPrime) {
        notPrime[0] = notPrime[1] = true;
        for(int i = 2; i*i <= 1000; i++) {
            if(!notPrime[i]) {
                for(int j = i*i; j <= 1000; j+=i) {
                    notPrime[j] = true;
                }
            }
        }
        return notPrime;
    }

}