import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int matrix[][] = new int[N+1][2];
        for(int i =1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }
        int dp[][] = new int[N + 1][N + 1];
        for(int i=1;i<=N;i++){
            for(int from = 1;from +i<=N;from++){
                int to = from+i;
                dp[from][to] = Integer.MAX_VALUE;
                for(int divide = from;divide<to;divide++){
                    dp[from][to] = Math.min(dp[from][to],dp[from][divide]+dp[divide+1][to]+(matrix[from][0]*matrix[divide][1]*matrix[to][1]));
                }
            }
        }
        System.out.println(dp[1][N]);
    }
}