
import java.io.*;
import java.util.*;


public class Main {
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        board = new char[N][2*N-1];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 2*N-1; j++){
                board[i][j] = ' ';
            }
        }

        star(0, N-1, N);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < 2*N-1; j++){
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void star(int x, int y, int N){
        if(N == 3){
            board[x][y] = '*';
            board[x+1][y-1] = board[x+1][y+1] = '*';
            for(int i = -2; i <= 2; i++){
                board[x+2][y+i] = '*';
            }
            return;
        }

        star(x, y, N/2);
        star(x+ (N/2), y - N/2, N/2);
        star(x + (N/2), y + N/2, N/2);

    }


}