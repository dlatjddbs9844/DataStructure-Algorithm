
import java.io.*;
import java.util.*;

public class Main {
    static int[][] dist;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dist = new int[n+1][n+1];

        for(int i= 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                if(i != j) dist[i][j] = INF;
            }
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dist[u][v] = Math.min(dist[u][v], w);
        }



        for(int mid = 1; mid <= n; mid++){
            for(int start = 1; start <= n; start++){
                for(int end = 1; end <= n; end++){
                    dist[start][end] = Math.min(dist[start][end], dist[start][mid] + dist[mid][end]);
                }
            }
        }

        for(int i= 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(dist[i][j] == INF) {
                    System.out.print(0 + " ");
                } else{
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }



    }

}