
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String[] command = new String[10000];
            boolean[] visited = new boolean[10000];
            Queue<Integer> q = new LinkedList<>();
            for(int j = 0; j < 10000; j++){
                command[j] = "";
            }

            visited[a] = true;
            q.add(a);
            while(!q.isEmpty() && !visited[b]){
                int cur = q.poll();
                int D = (cur*2) % 10000;
                int S = (cur == 0) ? 9999 : cur-1;
                int L = (cur % 1000) * 10 + cur / 1000;
                int R = (cur % 10) * 1000 + cur / 10 ;

                if(!visited[D]){
                    q.add(D);
                    visited[D] = true;
                    command[D] = command[cur] + "D";
                }

                if(!visited[S]){
                    q.add(S);
                    visited[S] = true;
                    command[S] = command[cur] + "S";
                }

                if(!visited[L]){
                    q.add(L);
                    visited[L] = true;
                    command[L] = command[cur] + "L";
                }

                if(!visited[R]){
                    q.add(R);
                    visited[R] = true;
                    command[R] = command[cur] + "R";
                }
            }
            System.out.println(command[b]);
        }
    }
}