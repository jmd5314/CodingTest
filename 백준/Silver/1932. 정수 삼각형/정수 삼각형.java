import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int dp[][];
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int max = Integer.MIN_VALUE;
        dp = new int[N][N];
        for(int i =0;i<N;i++){
            for(int j =0;j<=i;j++){
                dp[i][j] = sc.nextInt();
            }
        }
        for(int i =1;i<N;i++){
            for(int j =0;j<=i;j++){
                if(j==0)
                    dp[i][j] = dp[i][j]+dp[i-1][j];
                else if(j==i)
                    dp[i][j] = dp[i][j]+dp[i-1][j-1];
                else
                    dp[i][j] = dp[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }
        for(int i=0;i<N;i++){
            if(dp[N-1][i]>max)
                max = dp[N - 1][i];
        }
        System.out.println(max);
    }
}