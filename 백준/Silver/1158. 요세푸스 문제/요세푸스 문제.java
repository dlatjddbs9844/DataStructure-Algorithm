
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        sb.append('<');
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++){
            q.add(i);
        }

        while(!q.isEmpty()){
            for(int i = 0; i < k-1; i++){
                q.add(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }
        sb.delete(sb.length()-2, sb.length()).append('>');

        System.out.println(sb);
    }
}
