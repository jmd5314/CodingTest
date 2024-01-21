import java.io.*;
import java.util.*;
public class Main {
    public static long dp[][];
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new long[N+1][10];
        for(int i=1;i<=9;i++){
            dp[1][i] = 1;
        }
        for(int i=2;i<=N;i++){
            for(int j=0;j<10;j++) {
                // 자릿값이 0일때는 1로부터 밖에 못온다
                if(j==0){
                    dp[i][j] = dp[i-1][1]%1000000000;
                }
                //자릿값이 9일때는 8로부터 밖에 못온다
                else if(j==9){
                    dp[i][j] = dp[i-1][8]%1000000000;
                }
                //나머지 수들은 -1, +1 값으로부터 올 수 있다
                else{
                    dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
                }
            }
        }
        long sum = 0;
        for(int i =0;i<10;i++){
            sum+=dp[N][i];
        }
        System.out.println(sum%1000000000);
    }
}