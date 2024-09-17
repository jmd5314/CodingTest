import java.util.*;
import java.io.*;

public class Main {
    static class Coin {
        int v;
        int q;

        Coin(int v, int q) {
            this.v = v;
            this.q = q;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = 3;
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Coin[] coins = new Coin[N];
            boolean[] dp = new boolean[50001]; // DP 배열 초기화
            dp[0] = true; // 0원은 항상 만들 수 있음
            int sum = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                coins[i] = new Coin(v, q);
                sum += v * q;
            }

            // 총 금액이 홀수면 반으로 나눌 수 없으므로 0 출력
            if (sum % 2 == 1) {
                sb.append(0).append("\n");
                continue;
            }

            int target = sum / 2; // 목표 금액 (절반)

            // 동전들을 사용하여 만들 수 있는 금액 확인
            for (Coin coin : coins) {
                int v = coin.v;
                int q = coin.q;
                // 내림차순으로 DP 업데이트 (동전 여러 개를 사용할 수 있도록)
                for (int j = target; j >= v; j--) {
                    if (dp[j - v]) {
                        for (int k = 1; k <= q && j - v + v * k <= target; k++) {
                            dp[j - v + v * k] = true;
                        }
                    }
                }
            }

            // 목표 금액이 가능한지 확인
            sb.append(dp[target] ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }
}