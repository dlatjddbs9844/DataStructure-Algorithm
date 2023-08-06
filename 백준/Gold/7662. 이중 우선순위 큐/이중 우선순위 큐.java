
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            int K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            while(K --> 0){
                st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());
                if(cmd == 'I'){
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else if(cmd == 'D') {
                    if(!map.isEmpty()){
                        // 최댓값 삭제
                        if(n == 1) {
                            int num = map.lastKey();
                            if(map.put(num, map.get(num) - 1) == 1) {
                                map.remove(num);
                            }
                        } else {
                            int num = map.firstKey();
                            if(map.put(num, map.get(num) -1) == 1){
                                map.remove(num);
                            }
                        }
                    }
                }
            }
            if(!map.isEmpty()){
                System.out.println(map.lastKey() + " " + map.firstKey());
            }else{
                System.out.println("EMPTY");
            }

        }
    }
}
