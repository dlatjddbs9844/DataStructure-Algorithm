import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int min = 64;
    static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new boolean[n][m];
        String str;
        for(int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'B') {
                    arr[i][j] = false;
                }
                else{
                    arr[i][j] = true;
                }
            }
        }

        int n_row = n - 7;
        int m_col = m - 7;
        for(int i = 0; i < n_row; i++) {
            for(int j = 0; j < m_col; j++) {
                ans(i, j);
            }
        }
        System.out.println(min);
    }

    public static void ans(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int cnt = 0;

        boolean color = arr[x][y];

        for(int i = x; i < end_x; i++){
            for(int j = y; j < end_y; j++) {
                if(arr[i][j] != color) {
                    cnt++;
                }
                color = !color;
            }
            color = !color;
        }
        cnt = Math.min(cnt, 64-cnt);
        min = Math.min(min, cnt);
    }

}