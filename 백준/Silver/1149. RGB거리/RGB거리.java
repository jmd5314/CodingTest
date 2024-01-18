import java.io.*;
import java.util.*;

public class Main {
    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;
    public static int N;
    public static int price[][];
    public static int dp[][];
    public static int min_price(int N, int color){
        //만약 탐색하지 않은 배열이라면
        if(dp[N][color]==0){
            if(color==Red){
                dp[N][Red] = Math.min(min_price(N - 1, Green), min_price(N - 1, Blue)) + price[N][Red];
            }
            else if(color==Green){
                dp[N][Green] = Math.min(min_price(N-1,Red),min_price(N-1,Blue))+price[N][Green];
            }
            else
                dp[N][Blue] = Math.min(min_price(N - 1, Red), min_price(N - 1, Green)) + price[N][Blue];
        }
        return dp[N][color];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        price = new int[N][3];
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N][3];
        dp[0][Red] = price[0][Red];
        dp[0][Green] = price[0][Green];
        dp[0][Blue] = price[0][Blue];
        //첫번째 집 색이 빨강, 초록, 파랑일때 중 가장 값이 작을때를 출력한다
        int result = Math.min(min_price(N-1, Green), Math.min(min_price(N-1, Red), min_price(N-1, Blue)));
        System.out.println(result);
    }
}