
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stk = new Stack<>();

        String str = br.readLine();
        String bomb = br.readLine();
        int bombLength = bomb.length();

        for(int i = 0; i < str.length(); i++){
            stk.push(str.charAt(i));

            if(stk.size() >= bombLength){
                boolean isExist = true;
                for(int j = 0; j < bombLength; j++){
                    if(stk.get(stk.size()-bombLength + j) != bomb.charAt(j)){
                        isExist = false;
                        break;
                    }
                }

                if (isExist){
                    for(int j = 0; j < bombLength; j++){
                        stk.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(Character ch : stk){
            sb.append(ch);
        }
        if(sb.length() == 0) {
            System.out.println("FRULA");
        }else{
            System.out.println(sb);
        }


    }
}