import java.util.*;
import java.io.*;

class Coord{
    int x;
    int y;
    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int x, y;
        Coord[] coord = new Coord[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            coord[i] = new Coord(x, y);
        }
        Arrays.sort(coord, new Comparator<Coord>() {
            @Override
            public int compare(Coord o1, Coord o2) {
                if(o1.x == o2.x) {
                    return o1.y - o2.y;
                } else{
                    return o1.x - o2.x;
                }
            }
        });

        for(int i = 0; i < n; i++) {
            System.out.println(coord[i].x + " " + coord[i].y);
        }

    }

}