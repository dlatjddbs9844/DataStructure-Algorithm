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
        isPrime2(start, end);
    }
    
    public static void isPrime2(int start, int end) {
        boolean[] isntPrime = new boolean[end+1];
        isntPrime[0] = isntPrime[1] = true;
        for(int i = 2; i*i <= end; i++) {
            if(!isntPrime[i]) {
                for(int j = i * i; j <= end; j+=i) {
                    isntPrime[j] = true;
                }
            }
        }

        for(int i = start; i <= end; i++) {
            if(isntPrime[i] == false) {
                System.out.println(i);
            }
        }

    }
}
