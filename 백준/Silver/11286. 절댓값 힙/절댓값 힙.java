
import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Abs implements Comparable<Abs>{
    int original;
    int abs;
    Abs(int original){
        this.original = original;
        this.abs = Math.abs(original);
    }

    @Override
    public int compareTo(Abs o1){
        if(this.abs == o1.abs){
            return this.original - o1.original;
        }
        return this.abs - o1.abs;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Abs> pq = new PriorityQueue();

        while(n --> 0){
            int x = Integer.parseInt(br.readLine());
            if(x != 0){
                pq.add(new Abs(x));
            } else{
                if(pq.isEmpty()){
                    sb.append(0).append('\n');
                } else{
                    Abs abs = pq.poll();
                    sb.append(abs.original).append('\n');
                }

            }
        }
        System.out.println(sb);
    }

}