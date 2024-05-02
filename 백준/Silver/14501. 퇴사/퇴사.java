import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int [] dp;
    static int [] T;
    static int [] P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        // 마지막날도 진료를 할 수도 있기때문에 N+1로 설정
        dp = new int[N+1];
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        for(int i =0;i<N;i++){
            // 범위안에 존재하면
            if(i+T[i]<=N){
                // 원래 dp 값과 현재 진료 이후의 비용울 더한 값 중 더 높은 값을 채택
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
            // 다음 dp 를 현재 누적값과 다음 누적값 중 더 높은 값으로 초기화해야 계속 누적됨
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }
        System.out.println(dp[N]);
    }
}