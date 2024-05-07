import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        for(int i = 1;i<=N;i++){
            // 모든 숫자는 1만으로 표현 가능하기때문에 자기자신으로 초기화
            dp[i] = i;
            // i보다 낮은 제곱수를 뺀 나머지 값의 dp값 + 1이 현재 dp 보다 작다면 초기화
            for(int j = 1;j*j<=i;j++){
                // j*j 제곱수를 빼면 그 제곱수의 dp는 무조건 1 이므로 1을 더함
                if (dp[i] > dp[i - j * j] + 1) {
                    dp[i] = dp[i - j * j] + 1;
                }
            }
        }
        System.out.println(dp[N]);
    }
}