import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int[] dp = new int[N];
        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = num[0];
        max = dp[0];
        for(int i =1;i<N;i++){
            // 이전 순서에 자신보다 더 낮은 값이 나오지 않을 수 있으므로 현재 값으로 초기화
            dp[i] = num[i];
            for(int j =i-1;j>=0;j--){
                if(num[j]<num[i]){
                    dp[i] = Math.max(dp[j] + num[i], dp[i]);
                }
            }
            if(max<dp[i])
                max = dp[i];
        }
        System.out.println(max);
    }
}