import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int weather[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            weather[i] = Integer.parseInt(st.nextToken());
        }
        int sum[] = new int[N-K+1];
        for(int i =0;i<K;i++){
            sum[0]+=weather[i];
        }
        int max = sum[0];
        for(int i =1;i<N-K+1;i++){
            sum[i] = sum[i-1]-weather[i-1]+weather[i+K-1];
            if(sum[i]>max)
                max = sum[i];
        }
        System.out.println(max);
    }
}