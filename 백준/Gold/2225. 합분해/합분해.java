import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [][] dp = new int[K+1][N+1];
        for(int i =1;i<=K;i++){
            // K 값에 상관없이 0을 만드는 경우는 무조건 1가지임
            dp[i][0] = 1;
        }
        // dp[K][N] = dp[K-1][N] + dp[K][N-1]
        for(int i =1;i<=K;i++){
            for(int j=1;j<=N;j++){
                dp[i][j] = (dp[i - 1][j] + dp[i][j-1])%1000000000;
            }
        }
        System.out.println(dp[K][N]);
    }
}