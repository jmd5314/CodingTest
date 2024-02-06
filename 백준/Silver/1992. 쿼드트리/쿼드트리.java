import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] square;
    public static void countSquare(int start_i,int start_j,int size){
        int num = square[start_i][start_j];
        for(int i =start_i;i<start_i+size;i++){
            for(int j=start_j;j<start_j+size;j++){
                if(square[i][j]!=num){
                    sb.append("(");
                    countSquare(start_i,start_j,size/2);
                    countSquare(start_i,start_j+size/2,size/2);
                    countSquare(start_i + size / 2, start_j, size / 2);
                    countSquare(start_i + size / 2, start_j + size / 2, size / 2);
                    sb.append(")");
                    return;
                }
            }
        }
        sb.append(num);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        square = new int[N][N];
        for(int i =0;i<N;i++){
            String num = br.readLine();
            for(int j=0;j<N;j++){
                square[i][j] = num.charAt(j) - '0';
            }
        }
        countSquare(0,0,N);
        System.out.println(sb);
    }
}