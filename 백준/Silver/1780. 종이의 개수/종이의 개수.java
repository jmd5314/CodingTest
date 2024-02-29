import java.util.*;
import java.io.*;

public class Main {
    static int[][] square;
    static int count1=0,count2=0,count3=0;
    public static void countSquare(int start_i,int start_j,int size){
        int num = square[start_i][start_j];
        for(int i =start_i;i<start_i+size;i++){
            for(int j=start_j;j<start_j+size;j++){
                if(square[i][j]!=num){
                    countSquare(start_i,start_j,size/3);
                    countSquare(start_i,start_j+size/3,size/3);
                    countSquare(start_i,start_j+2*size/3,size/3);
                    countSquare(start_i+size/3,start_j,size/3);
                    countSquare(start_i+size/3,start_j+size/3,size/3);
                    countSquare(start_i+size/3,start_j+2*size/3,size/3);
                    countSquare(start_i+2*size/3,start_j,size/3);
                    countSquare(start_i+2*size/3,start_j+size/3,size/3);
                    countSquare(start_i+2*size/3,start_j+2*size/3,size/3);
                    return;
                }
            }
        }
        // 다른 수 없이 모두 통과했을때
        if(num==-1)
            count1++;
        else if (num==0)
            count2++;
        else
            count3++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        square = new int[N][N];
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                square[i][j] = Integer.parseInt(st.nextToken());
        }
    }
        countSquare(0,0,N);
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
}
}