import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i =0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int a = 0,b=0;
            if(N%H==0){
                a= N/H;
                b= H;
            }
            else{
                a= N/H+1;
                b = N%H;
            }
            System.out.println(b*100+a);
        }
    }
}