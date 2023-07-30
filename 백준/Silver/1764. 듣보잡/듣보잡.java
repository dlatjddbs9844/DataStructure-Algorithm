
import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        HashSet<String> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            set.add(br.readLine());
        }

        for(int i = 0; i < m; i++){
            String str = br.readLine();
            if(set.contains(str)) {
                result.add(str);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }



    }
}