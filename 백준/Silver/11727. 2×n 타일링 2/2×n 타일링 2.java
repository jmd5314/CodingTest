import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[1] = 1;
        // N이 1일 수도 있기때문에 N이 1보다 높은 경우에만 dp[2]를 초기화 해줌
        if(N>1)
            dp[2] = 3;
        /*
         * dp[n] = dp[n-1] 타일 뒤에 1*2밖에 올 수 없고, dp[n-2] 타일 뒤에 2*2 타일 혹은 2*1 타일 2개가 올 수 있으므로
         * dp[n] = dp[n-1] + dp[n-2] * 2
         */
        for(int i =3;i<=N;i++){
            dp[i] =( dp[i - 1] % 10007 + (dp[i - 2] * 2) % 10007)%10007;
        }
        System.out.println(dp[N]);
    }
}