
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<String, Double> map = new HashMap<String, Double>();
        double total = 0;
        double sum = 0;

        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        for(int i = 0; i < 20; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double ng = Double.parseDouble(st.nextToken());
            String lg = st.nextToken();

            if(!lg.equals("P")){
                sum += ng;
                total += ng*map.get(lg);
            }

        }

        System.out.printf("%.6f", total / sum);
    }
}