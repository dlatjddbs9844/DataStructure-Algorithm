import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringTokenizer st;
        Stack<Character> stk = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            stk.clear();
            str = br.readLine();
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '('){
                    stk.push('(');
                }
                else{
                    if(stk.isEmpty()){
                        stk.push(')');
                    } else{
                        if(stk.peek() == '(') {
                            stk.pop();
                        }
                    }
                }
            }
            if(stk.isEmpty()) {
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }

        }
    }

}