import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] visited = new boolean[100001];
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(n == m) {
            System.out.println(0);
            return;
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        int size = q.size();
        int cnt = 0;
        while(!q.isEmpty()) {
            cnt++;
            size = q.size();
            for(int i = 0; i < size; i++){
                int v = q.poll();
                if(v-1 == m || v + 1 == m || 2*v == m) {
                    System.out.println(cnt);
                    return;
                }
                if(v - 1 >= 0 && !visited[v-1]) {
                    visited[v-1] = true;
                    q.add(v-1);
                }
                if(v + 1 <= 100000 && !visited[v+1]){
                    visited[v+1] = true;
                    q.add(v+1);
                }
                if(2*v <= 100000 && !visited[2*v]){
                    visited[2*v] = true;
                    q.add(2*v);
                }
            }
        }
    }


}
