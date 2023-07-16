
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    Node first, last;
    LinkedList(){
        this.first = null;
        this.last = null;
    }
    public boolean isEmpty(){
        return first == null;
    }

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(isEmpty()) {
            first = last = newNode;
        } else{
            last.next = newNode;
            last = newNode;
        }
    }

    public int deleteAtFirst() {
        int ret;
        if(isEmpty()) return -1;
        ret = first.data;
        first = first.next;
        if(first == null) last = null;
        return ret;
    }

    public int getFirst(){
        int ret;
        if(isEmpty()) return -1;
        ret = first.data;
        return ret;
    }
    public int getLast(){
        int ret;
        if(isEmpty()) return -1;
        ret = last.data;
        return ret;
    }
}

class Queue{
    LinkedList llist;
    int size;
    Queue() {
        this.llist = new LinkedList();
        this.size = 0;
    }

    public void isEmpty(){
        if(llist.isEmpty()){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    public void push(int data) {
        llist.insertAtEnd(data);
        size++;
    }
    public void pop() {
       System.out.println(llist.deleteAtFirst());
       if(size > 0){
           size--;
       }
    }
    public void size(){
        System.out.println(size);
    }
    public void front(){
        System.out.println(llist.getFirst());
    }
    public void back(){
        System.out.println(llist.getLast());
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Queue q = new Queue();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("push")) {
                int data = Integer.parseInt(st.nextToken());
                q.push(data);
            } else{
                if(order.equals("front")){
                    q.front();
                } else if(order.equals("back")){
                    q.back();
                } else if(order.equals("pop")){
                    q.pop();
                } else if(order.equals("size")){
                    q.size();
                } else if(order.equals("empty")){
                    q.isEmpty();
                }
            }
        }
    }
}
