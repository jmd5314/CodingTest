import java.io.*;
import java.util.*;
public class Main {
    static boolean[][] dp;
    public static void isPal(int[] num, int n){
        // 길이가 1인 경우
        for(int i = 1; i <= n; i++)
            dp[i][i] = true;
        // 길이가 2인 경우
        for(int i = 1; i <= n - 1; i++)
            if(num[i] == num[i + 1])
                dp[i][i + 1]= true;
        // 길이가 3 이상인 경우
        for(int i = 2; i < n; i++){
            for(int j = 1; j <= n - i; j++){
                if(num[j] == num[j + i] && dp[j + 1][j + i - 1])
                    dp[j][j + i] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] num = new int[n + 1];
        dp = new boolean[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n; i++)
            num[i] = Integer.parseInt(st.nextToken());

        isPal(num, n);
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(dp[start][end]) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.println(sb);
    }
}