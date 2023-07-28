
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr;
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            arr = br.readLine().split(" ");
            for(int j = 0; j < arr.length; j++){
                System.out.print(reverse(arr[j]) + " ");
            }
            System.out.println();
        }
    }

    public static String reverse(String str) {
        Stack<Character> stk = new Stack();
        String ret = "";
        for(int i = 0; i < str.length(); i++){
            stk.push(str.charAt(i));
        }

        for(int i = 0; i < str.length(); i++){
            ret += stk.pop();
        }
        return ret;
    }
}