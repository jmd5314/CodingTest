import java.io.*;
import java.util.*;

public class Main {
    public static int dp[];
    public static int stairs[];
    public static int  max_stairs(int N){
        if(dp[N]==-1){
            dp[N] = Math.max(max_stairs(N - 2), max_stairs(N - 3) + stairs[N - 1]) + stairs[N];
        }
        return dp[N];
    }
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        stairs = new int[N+1];
        dp = new int[N+1];
        for(int i =1;i<=N;i++){
            dp[i] = -1;
            stairs[i] = sc.nextInt();
        }
        dp[0] = stairs[0];
        dp[1] = stairs[1];
        if(N>=2){
            dp[2] = stairs[1] + stairs[2];
        }
        System.out.println(max_stairs(N));
    }
}