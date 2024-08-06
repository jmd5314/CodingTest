import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int [] arr;
    static int[] dp;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            // 자기 자신만 있는 경우
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if(dp[i]>max)
                max = dp[i];
        }
        System.out.println(N - max);
    }
}