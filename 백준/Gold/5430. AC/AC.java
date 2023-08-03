import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> dq;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();

            dq = new ArrayDeque<>();

            arr = arr.substring(1, arr.length()-1);
            String[] str = arr.split(",");


            for(int j = 0; j < n; j++) {
                dq.add(Integer.parseInt(str[j]));
            }

            AC(cmd, dq);
        }
        System.out.println(sb);
    }
    public static void AC(String order, ArrayDeque<Integer> dq){
        boolean isRight = true;
        for(char cmd : order.toCharArray()){
            if(cmd == 'R') {
                isRight = !isRight;
                continue;
            }

            if(isRight){
                if(dq.pollFirst() == null){
                    sb.append("error\n");
                    return;
                }
            }else{
                if(dq.pollLast() == null){
                    sb.append("error\n");
                    return;
                }
            }
        }
        getAns(dq, isRight);
    }

    public static void getAns(ArrayDeque<Integer> dq, boolean isRight){
        sb.append('[');
        if(dq.size() > 0) {
            if(isRight) {
                sb.append(dq.pollFirst());
                while(!dq.isEmpty()){
                    sb.append(',').append(dq.pollFirst());
                }
            }else{
                sb.append(dq.pollLast());
                while(!dq.isEmpty()){
                    sb.append(',').append(dq.pollLast());
                }
            }
        }
        sb.append(']').append('\n');
    }

}