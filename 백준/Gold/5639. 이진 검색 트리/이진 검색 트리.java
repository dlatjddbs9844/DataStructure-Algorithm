
import java.io.*;
import java.util.*;

class Node{
    Node left;
    Node right;
    int data;
    Node(int data){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class Tree{
    Node root;
    Tree(){
        this.root = null;
    }
    public void insert(int data){
        Node newNode = new Node(data);
        if(root == null) {
            root = newNode;
            return;
        }
        Node cur = root;
        Node parent = root;
        while(cur != null){
            parent = cur;
            if(cur.data > data){
                cur = cur.left;
            } else{
                cur = cur.right;
            }
        }

        if(parent.data > data){
            parent.left = newNode;
        }else{
            parent.right = newNode;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Tree tree = new Tree();
        // Init
        while(true){
            String input = br.readLine();
            if(input == null || input.equals("")){
                break;
            }
            int data = Integer.parseInt(input);
            tree.insert(data);
        }

        postOrder(tree.root);
    }

    public static void postOrder(Node cur){
        if(cur == null) return;
        postOrder(cur.left);
        postOrder(cur.right);
        System.out.println(cur.data);
    }


}