import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] m,c;
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        m = new int[N];
        c = new int[N];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            m[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            c[i] = Integer.parseInt(st.nextToken());
            sum += c[i];
        }
        //dp[i][j] = i번째 앱까지 사용했을때 j의 비용으로 얻을 수 있는 최대 메모리
        //dp[i][j] = dp[i-1][j], dp[i-1][j-cost[i]]+m[i] 중 더 큰값
        dp = new int[N][sum+1];
        for(int i=0;i<=sum;i++){
            // 0번째 앱의 비용보다 작은 비용은 0으로 초기화 더 큰 비용은 0번째 앱의 메모리 만큼 초기화
            if(i<c[0])
                dp[0][i] = 0;
            else
                dp[0][i] = m[0];
        }
        for(int i =1;i<N;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j] = dp[i - 1][j];
                if(j-c[i]>=0)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i]] + m[i]);
            }
        }
        // M 만큼의 메모리를 확보해야되는 것이기에 M 이상의 메모리를 얻을 수 있는 최소 비용을 찾아 출력함
        for(int i =0;i<=sum;i++){
            if(dp[N-1][i]>=M){
                System.out.println(i);
                System.exit(0);
            }
        }
    }
}