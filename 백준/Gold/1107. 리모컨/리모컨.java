import java.io.*;
import java.util.*;

public class Main {
    static final int CH = 100;
    static boolean[] isBroken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 이동하고자 하는 채널
        int n = Integer.parseInt(br.readLine());
        // 고장난 버튼의 개수
        int m = Integer.parseInt(br.readLine());
        if(m != 0) {
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                int tmp = Integer.parseInt(st.nextToken());
                isBroken[tmp] = true;
            }
        }

        int result = Math.abs(n - 100);
        for(int i = 0; i <= 999999; i++){
            String str = Integer.toString(i);
            int len = str.length();
            boolean isExist = true;
            for(int j = 0; j < str.length(); j++){
                int tmp = Integer.parseInt("" + str.charAt(j));
                if(isBroken[tmp]) {
                    isExist = false;
                     break;
                }
            }
            if(isExist) {
                int tmp = Math.abs(n-i) + len;
                result = Math.min(tmp, result);
            }
        }
        System.out.println(result);


    }



}
