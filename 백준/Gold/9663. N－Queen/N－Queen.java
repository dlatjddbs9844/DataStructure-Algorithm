import java.io.*;

public class Main {
    static int cnt = 0;
    static int[] board;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n];

        for(int i = 0; i < n; i++){
            board[0] = i;
            nqueen(1);
        }
        System.out.println(cnt);
    }
    public static void nqueen(int col){
        if(col == n){
            cnt+=1;
            return;
        }
        for(int i = 0; i < n; i++){
            boolean promising = true;
            for(int j = 0; j < col; j++) {
                board[col] = i;
                if(board[j] == board[col] || Math.abs(j - col) == Math.abs(board[j] - board[col])){
                    promising = false;
                    break;
                }
            }
            if(promising) {
                nqueen(col+1);
            }
        }
    }
    

}
