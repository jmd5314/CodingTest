import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int points[][] = new int[N][2];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < 2; j++) {
                points[i][j] = sc.nextInt();
            }
        Arrays.sort(points,(v1,v2)->{
            if(v1[0]==v2[0])
                return v1[1]-v2[1];
            else
                return v1[0]-v2[0];
        });
        for(int i = 0;i<N;i++){
            for(int j=0;j<2;j++){
                System.out.print(points[i][j]+" ");
            }
            System.out.println();
        }
    }
}