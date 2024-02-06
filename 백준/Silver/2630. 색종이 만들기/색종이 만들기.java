import java.util.*;
import java.io.*;

public class Main {
    static int count_w = 0, count_b = 0;
    static int[][] square;
    public static void countSquare(int start_i,int start_j,int size){
        int num = square[start_i][start_j];
        for(int i =start_i;i<start_i+size;i++){
            for(int j=start_j;j<start_j+size;j++){
                if(square[i][j]!=num){
                    countSquare(start_i,start_j,size/2);
                    countSquare(start_i,start_j+size/2,size/2);
                    countSquare(start_i + size / 2, start_j, size / 2);
                    countSquare(start_i + size / 2, start_j + size / 2, size / 2);
                    return;
                }
            }
        }
        if(num==0)
            count_w++;
        else
            count_b++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        square = new int[N][N];
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        countSquare(0,0,N);
        System.out.println(count_w);
        System.out.println(count_b);
    }
}