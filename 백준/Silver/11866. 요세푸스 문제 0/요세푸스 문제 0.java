
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[n];
        for(int i = 1; i <= n; i++) {
            q.add(i);
        }
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < k; j++) {
                int x = q.poll();
                q.add(x);
            }
            ans[i] = q.poll();
        }
        for(int i = 0; i < ans.length; i++) {
            if(i == 0) {
                sb.append('<').append(ans[i]);
                if (ans.length == 1){
                    sb.append('>');
                }
            }
            else if(i == ans.length - 1) {
                if (ans.length-1 != 0) {
                    sb.append(", ");
                }
                sb.append(ans[i]).append('>');
            }
            else{
                sb.append(", ").append(ans[i]);
            }
        }
        System.out.println(sb);
    }
}
