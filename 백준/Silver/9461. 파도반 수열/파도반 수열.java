import java.io.*;
import java.util.*;
public class Main{
    public static long dp[] = new long[100];
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for(int i =0;i<T;i++){
        int N = Integer.parseInt(br.readLine());
        for(int j=3;j<N;j++){
            if(dp[j]!=0)
                continue;
            dp[j] = dp[j - 2] + dp[j - 3];
        }
            sb.append(dp[N - 1]).append("\n");
        }
        System.out.println(sb);
    }
}