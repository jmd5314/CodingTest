import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int num[] = new int[N];
        int dp[][] = new int[N][2];
        for(int i =0;i<N;i++){
            num[i] = sc.nextInt();
        }
        for(int i =0;i<N;i++){
            //0은 증가할때 1은 감소할때
            dp[i][0] = 1;
            dp[i][1] = 1;
            for(int j = 0;j<i;j++){
                //j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1값보다 작은 경우
                if(num[j]<num[i]&&dp[i][0]<dp[j][0]+1){
                    dp[i][0] = dp[j][0]+1;
                }
                //j번째 원소가 i번째 원소보다 크면서 i번째 증가 dp 와 감소 dp중 더 큰 값을 더한다.
                else if(num[j]>num[i]&&dp[i][1]<Math.max(dp[j][0],dp[j][1])+1){
                    dp[i][1] = Math.max(dp[j][0],dp[j][1])+1;
                }
            }
        }
        int max = 1;
        for(int i =0;i<N;i++){
            if(Math.max(dp[i][0],dp[i][1])>max)
                max = Math.max(dp[i][0],dp[i][1]);
        }
        System.out.println(max);
    }
}