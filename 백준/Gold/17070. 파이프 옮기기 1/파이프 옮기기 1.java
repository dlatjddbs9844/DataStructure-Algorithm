
import java.awt.print.PrinterIOException;
import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[][] board;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        board = new int[N+1][N+1];
        ans = 0;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 2,0);

        System.out.println(ans);
    }

    public static void dfs(int x, int y, int direction){
        if(x == N && y == N){
            ans++;
            return;
        }

        // 0 : 가로, 1 : 세로, 2 : 대각
        if(direction == 0){
            if(y+1 <= N && board[x][y+1] != 1){
                dfs(x, y+1, 0);
            }
        }
        else if(direction == 1) {
            if(x+1 <= N && board[x+1][y] != 1){
                dfs(x+1, y, 1);
            }
        }
        else{
            if(y+1 <= N && board[x][y+1] != 1){
                dfs(x, y+1, 0);
            }
            if(x+1 <= N && board[x+1][y] != 1){
                dfs(x+1, y, 1);
            }
        }

        if(x+1 <= N && y+1 <= N && board[x][y+1] != 1 && board[x+1][y] != 1 && board[x+1][y+1] != 1){
            dfs(x+1, y+1, 2);
        }
    }




}