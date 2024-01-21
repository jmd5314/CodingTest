import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int wine[] = new int[N+1];
        int dp[] = new int[N+1];
        for(int i =1;i<=N;i++){
            wine[i] = sc.nextInt();
        }
        dp[0] = wine[0];
        dp[1] = wine[1];
        if (N >= 2) {
            dp[2] = wine[1]+wine[2];
        }
        for(int i =3;i<=N;i++){
            dp[i] = Math.max(dp[i-1],Math.max(dp[i - 2], dp[i - 3] + wine[i - 1]) + wine[i]);
        }
        System.out.println(dp[N]);
    }
}