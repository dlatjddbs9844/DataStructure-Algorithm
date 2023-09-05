import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(arr[0]);
        
        for(int i = 1; i < arr.length; i++){
            if(stk.peek() != arr[i]){
                stk.push(arr[i]);
            }
        }
        
        answer = new int[stk.size()];
        for(int i = answer.length-1; i >= 0; i--){
            answer[i] = stk.pop();
        }

        return answer;
    }
}