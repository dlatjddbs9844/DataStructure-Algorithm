import java.util.*;
import java.io.*;

class Big{
    int x;
    int y;
    int grade = 1;
    Big(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void plusGrade(){
        this.grade++;
    }
}
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Big[] arr = new Big[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Big(x, y);
        }
        for(int i = 0; i < n-1; i++){
            Big p1 = arr[i];
            for(int j = i+1; j < n; j++){
                Big p2 = arr[j];
                if(p1.x > p2.x && p1.y > p2.y){
                    p2.plusGrade();
                } else if(p1.x < p2.x && p1.y < p2.y) {
                    p1.plusGrade();
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(i == 0) {
                System.out.print(arr[i].grade);
            } else{
                System.out.print(" " + arr[i].grade);
            }
        }

    }


}