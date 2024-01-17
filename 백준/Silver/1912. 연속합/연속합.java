import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int num[];
    public static int dp[];
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = num[0];
        max = num[0];

        for (int i = 1; i < N; i++) {
            //i 까지의 합으로 될 수 있는 값들중 가장 높은 값을 dp[i]에 저장! 
            // 작은 값은 저장할 필요X 최댓값을 구하는 문제이기 때문에!
            dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}