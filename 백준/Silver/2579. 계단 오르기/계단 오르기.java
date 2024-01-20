import java.util.*;

public class Main {
    public static int dp[];
    public static int stairs[];
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
        for(int i =3;i<=N;i++){
            dp[i] = Math.max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i];
        }
        System.out.println(dp[N]);
    }
}