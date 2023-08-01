import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sorted = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
            sorted[i] = val;
        }

        Arrays.sort(sorted);

        int idx = 0;

        for(int num : sorted) {
            if(!map.containsKey(num)) {
                map.put(num, idx);
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int k : arr) {
            int ans = map.get(k);
            sb.append(ans).append(' ');
        }
        System.out.println(sb);
    }

}
