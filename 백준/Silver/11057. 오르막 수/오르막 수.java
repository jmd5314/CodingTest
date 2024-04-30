import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];
        for(int i =0;i<10;i++){
            dp[0][i] = 1;
        }
        /*
         dp[i][j]는 dp[i-1][j]부터 dp[i-1][9] 까지의 합과 같음
         */
        for(int i =1;i<=N;i++){
            for(int j = 0;j<10;j++){
                // 더할때마다 10007로 나눈 나머지를 저장하도록 함
                for(int k = j;k<10;k++){
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
        }
        // N-1까지 하면 N의 길이까지 0~9가 각각 몇번씩 나오는지 dp에 저장되고 dp[N][0]은 dp[N-1]의 각 자릿수의 모든 합과 같으므로 dp[N][0]을 출력
        System.out.println(dp[N][0]);
    }
}