import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int num[] = new int[N];
        st = new StringTokenizer(br.readLine());
        num[0] = Integer.parseInt(st.nextToken());
        for(int i =1;i<N;i++){
            num[i] = num[i-1]+Integer.parseInt(st.nextToken());
        }
        for(int k = 0;k<M;k++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if(i==1)
                System.out.println(num[j-1]);
            else
                System.out.println(num[j-1]-num[i-2]);
        }
    }
}