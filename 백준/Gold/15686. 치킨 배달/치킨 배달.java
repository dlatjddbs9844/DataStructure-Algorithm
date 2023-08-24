
import java.io.*;
import java.util.*;

class Pos{
    int x;
    int y;
    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int ans = Integer.MAX_VALUE;
    static int N, M;
    static ArrayList<Pos> chicken = new ArrayList<>();
    static ArrayList<Pos> house = new ArrayList<>();
    static boolean[] open;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int val = Integer.parseInt(st.nextToken());
                if(val == 1) {
                    house.add(new Pos(j, i));
                }
                else if(val == 2){
                    chicken.add(new Pos(j, i));
                }
            }
        }

        open = new boolean[chicken.size()];

        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int start, int cnt){
        // 문을 연 치킨집의 개수가 M개
        if(cnt == M) {
            int tot = 0;
            // 치킨 거리 비교 -> 최소거리 구함
            for(int i = 0; i < house.size(); i++){
                int min = Integer.MAX_VALUE;
                for(int j = 0; j < chicken.size(); j++){
                    if(open[j]) {
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        min = Math.min(min, distance);
                    }
                }
                tot += min;
            }

            ans = Math.min(tot, ans);

        }

        for(int i = start; i < chicken.size(); i++){
            open[i] = true;
            dfs(i+1, cnt+1);
            open[i] = false;
        }
    }

}