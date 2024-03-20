import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i =0;i<T;i++){
            int K = Integer.parseInt(br.readLine());
            int file[] = new int[K+1];
            int dp[][] = new int[K+1][K+1];
            int sum[] = new int[K + 1];
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=K;j++){
                file[j] = Integer.parseInt(st.nextToken());
                sum[j] = sum[j-1]+file[j];
            }
            // 1장부터 n장 까지 묶기 (n = 몇장을 묶을 것인지)
            for(int n=1;n<=K;n++){
                // 어디서부터 묶을 것인지
                for(int from = 1;from +n<=K;from++){
                 int to = from+n;
                    dp[from][to] = Integer.MAX_VALUE;
                    for(int divide = from;divide<to;divide++){
                        dp[from][to] = Math.min(dp[from][to],dp[from][divide]+dp[divide+1][to]+sum[to]-sum[from-1]);
                    }
                }
            }
            sb.append(dp[1][K]).append("\n");
        }
        System.out.println(sb);
    }
}