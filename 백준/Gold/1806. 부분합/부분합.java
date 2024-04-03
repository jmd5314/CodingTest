import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        //start 부터 end의 전까지의 부분합들이기 때문에 index 가 한개 더 필요함
        int [] num = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int l = Integer.MAX_VALUE;
        int sum = 0;
        while (start <= end && end <= N) {
            if(sum<S)
                sum += num[end++];
            else if(sum>=S){
                l = Math.min(l, end - start);
                sum -= num[start++];
            }
        }
        if(l==Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(l);
    }
}