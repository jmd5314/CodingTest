import java.io.*;
import java.util.*;

public class Main {
    static int N,r,c,l,result=0;
    public static void sequence(int sr,int sc,int size){
        if(size==1){
            System.out.println(result);
            return;
        }
        int newSize = size/2;
        // 1 사분면
        if(r<sr+newSize&&c<sc+newSize){
            sequence(sr,sc,newSize);
        }
        // 2 사분면
        else if(r<sr+newSize&&c>=sc+newSize){
            result+=(size*size)/4;
            sequence(sr, sc + newSize, newSize);
        }
        // 3 사분면
        else if(r>=sr+newSize&&c<sc+newSize){
            result+=(size*size)/2;
            sequence(sr + newSize, sc, newSize);
        }
        // 4 사분면
        else{
            result += (size * size) / 4 * 3;
            sequence(sr+newSize,sc+newSize,newSize);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        l = (int) Math.pow(2, N);
        sequence(0, 0, l);
    }
}