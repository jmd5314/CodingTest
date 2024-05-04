import java.util.*;
import java.io.*;
public class Main {
    static int [][]sticker;
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            int N = Integer.parseInt(br.readLine());
            sticker = new int[2][N];
            dp = new int[2][N];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 첫째 줄과 둘째줄의 첫번째 dp는 자기자신을 선택하는 것
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            int max = Math.max(dp[0][0], dp[1][0]);
            if(N>1){
                dp[0][1] = dp[1][0] + sticker[0][1];
                dp[1][1] = dp[0][0] + sticker[1][1];
                max = Math.max(dp[0][1], dp[1][1]);
            }
            for(int i =2;i<N;i++){
                // 반대쪽 줄의 i-1을 선택하거나 i-2을 선택하는 것중 더 값이 큰 값을 선택
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
                max = Math.max(dp[0][i], dp[1][i]);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}