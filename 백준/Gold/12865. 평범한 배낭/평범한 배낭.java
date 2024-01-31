import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)  throws  IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [][] product = new int[N+1][2]; // 0 은 무게 1은 가치
        int [][] dp = new int[N+1][K+1]; // 무게 0부터 K 까지의 dp 값 저장

        for(int i =1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            product[i][0] = Integer.parseInt(st.nextToken());
            product[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i =1;i<=N;i++){
            for(int j=1;j<=K;j++){
                // i번째 무게를 더 담을 수 없는 경우
                if(product[i][0]>j){
                    dp[i][j] = dp[i-1][j];
                }
                //i번째 무게를 더 담을 수 있는 경우
                //dp[i-1][j] 값과 현재 i값의 무게 값을 뺀 dp 값+ i의 가치 중 더 큰 수를 dp에 저장한다
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-product[i][0]]+product[i][1]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}