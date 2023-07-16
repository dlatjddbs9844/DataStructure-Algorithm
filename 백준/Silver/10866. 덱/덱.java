
import java.io.*;
import java.util.*;
class Node{
    int data;
    Node next;
    Node prev;
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
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

    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        if(isEmpty()){
            first = last = newNode;
        } else{
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
    }

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(isEmpty()) {
            first = last = newNode;
        } else{
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
    }

    public int deleteAtFirst() {
        int ret;
        if(isEmpty()) return -1;
        ret = first.data;
        first = first.next;
        if(first == null) last = null;
        else first.prev = null;
        return ret;
    }

    public int deleteAtEnd(){
        int ret;
        if(isEmpty()) return -1;
        ret = last.data;
        last = last.prev;
        if(last == null) first = null;
        else last.next = null;
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


class Dequeue{
    LinkedList llist;
    int size;
    Dequeue(){
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
    public void push_front(int data) {
        llist.insertAtFirst(data);
        size++;
    }
    public void push_back(int data){
        llist.insertAtEnd(data);
        size++;
    }
    public void pop_front(){
        System.out.println(llist.deleteAtFirst());
        if(size > 0){
            size--;
        }
    }
    public void pop_back(){
        System.out.println(llist.deleteAtEnd());
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

        Dequeue dq = new Dequeue();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if(order.equals("push_front")){
                int data = Integer.parseInt(st.nextToken());
                dq.push_front(data);
            } else if(order.equals("push_back")){
                int data = Integer.parseInt(st.nextToken());
                dq.push_back(data);
            } else if(order.equals("pop_front")){
                dq.pop_front();
            } else if(order.equals("pop_back")){
                dq.pop_back();
            } else if (order.equals("size")) {
                dq.size();
            } else if (order.equals("empty")){
                dq.isEmpty();
            } else if (order.equals("front")){
                dq.front();
            } else if (order.equals("back")){
                dq.back();
            }
        }
    }
}
