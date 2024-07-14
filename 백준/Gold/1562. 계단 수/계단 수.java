import java.io.*;
import java.util.*;

public class Main {
    static long answer;
    static int N;
    static long [][][] dp;
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;
        N = Integer.parseInt(br.readLine());
        /* dp[n][k][visit]
         * n : n 번째 자리는
         * k : k 라는 수 이며,
         * visit : n번째 자리까지 어떤 숫자를 사용했는지에 대한 정보
         */
        dp = new long[N + 1][10][1 << 10];
        for(int i =1;i<=9;i++){
            dp[1][i][1<<i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    int currK = k | (1 << j);
                    if (j == 0) dp[i][j][currK] += dp[i - 1][j + 1][k] % MOD;
                    else if (j == 9) dp[i][j][currK] += dp[i - 1][j - 1][k] % MOD;
                    else dp[i][j][currK] += (dp[i - 1][j - 1][k] % MOD + dp[i - 1][j + 1][k] % MOD);

                    dp[i][j][currK] %= MOD;
                }
            }
        }

        for (int k = 0; k <= 9; k++) {
            answer += dp[N][k][(1 << 10) - 1] % MOD;
            answer %= MOD;
        }
        System.out.println(answer);
    }
}