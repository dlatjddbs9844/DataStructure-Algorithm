
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Stack{
    int[] stk;
    int n;
    int top = -1;
    public Stack(int n) {
        this.n = n;
        this.stk = new int[n];
    }
    public int size() {
        return top+1;
    }
    public boolean isEmpty() {
        if(top < 0) return true;
        else return false;
    }
    public boolean isFull() {
        if(top+1 == n) return true;
        else return false;
    }
    public void push(int x) {
        if(!isFull()){
            stk[++top] = x;
        }
    }
    public int pop(){
        if(isEmpty()){
            return -1;
        }
        else {
            return stk[top--];
        }
    }
    public int peek(){
        if(isEmpty()){
            return -1;
        }else{
            return stk[top];
        }
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Stack stk = new Stack(n);
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                stk.push(x);
            }
            else if(order.equals("top")) {
                System.out.println(stk.peek());
            }
            else if(order.equals("size")){
                System.out.println(stk.size());
            }
            else if(order.equals("pop")) {
                System.out.println(stk.pop());
            }
            else if(order.equals("empty")){
                if(stk.isEmpty()){
                    System.out.println(1);
                } else{
                    System.out.println(0);
                }
            }
        }
    }
}
