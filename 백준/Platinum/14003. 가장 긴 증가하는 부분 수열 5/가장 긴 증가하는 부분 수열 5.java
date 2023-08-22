
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] p = new int[n];
        st = new StringTokenizer(br.readLine());

        list.add(Integer.MIN_VALUE);

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            int val = arr[i];
            int left = 0;
            int right = list.size() - 1;

            if(val > list.get(list.size()-1)){
                list.add(val);
                p[i] = list.size() - 1;
            }else{
                while(left < right){
                    int mid = (left + right) / 2;
                    if(list.get(mid) < val) left = mid + 1;
                    else right = mid;
                }

                list.set(right, val);
                p[i] = right;
            }
        }

        System.out.println(list.size()-1);

        int idx = list.size() - 1;
        Stack<Integer> stk = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            if(idx == p[i]) {
                idx--;
                stk.push(arr[i]);
            }
        }

        int s = stk.size();
        for(int i = 0; i < s; i++){
            System.out.print(stk.pop() + " ");
        }

    }
}