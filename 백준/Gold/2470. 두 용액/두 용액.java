import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long [] sol = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            sol[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(sol);
        int start = 0;
        int end = N - 1;
        long min = Long.MAX_VALUE;
        long sum = 0;
        long x = 0;
        long y = 0;
        while (start<end){
            sum = sol[start] + sol[end];
            if(Math.abs(sum)<min){
                min = Math.abs(sum);
                x= sol[start];
                y= sol[end];
                if(sum==0) break;
            }
            // 두수의 합이 0보다 작은지 큰지에 따라 pointer 를 바꿈
            if(sum<0)
                start++;
            else
                end--;
        }
        System.out.println(x+" "+y);
    }
}