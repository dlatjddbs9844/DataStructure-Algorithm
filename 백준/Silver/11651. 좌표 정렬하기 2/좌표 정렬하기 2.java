import java.util.*;
import java.io.*;

class Coord{
    int x;
    int y;
    Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Coord[] arr = new Coord[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Coord(x, y);
        }

        Arrays.sort(arr, new Comparator<Coord>() {
            @Override
            public int compare(Coord o1, Coord o2) {
                if(o1.y == o2.y) {
                    return o1.x - o2.x;
                } else {
                    return o1.y - o2.y;
                }
            }
        });

        for(int i = 0; i < n; i++) {
            System.out.println(arr[i].x + " " + arr[i].y);
        }

    }



}