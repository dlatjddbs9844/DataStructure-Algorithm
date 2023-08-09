import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            int year = x;
            int end = lcm(m, n);
            while(true){
                if(year > end){
                    System.out.println(-1);
                    break;
                }
                if((year % n) == 0){
                    if(n == y){
                        System.out.println(year);
                        break;
                    }
                } else{
                    if(year%n == y){
                        System.out.println(year);
                        break;
                    }
                }
                year += m;
            }


        }
    }
    public static int lcm(int x, int y){
        return (x*y) / gcd(x, y);
    }
    public static int gcd(int x, int y) {
        if(y == 0) {
            return x;
        }
        return gcd(y, x % y);

    }
}
