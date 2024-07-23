
import java.util.*;
import java.io.*;

class Solution
{
    static int N, L;
    static int[][] arr;
    static int [][] dp;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            // 0이 점수 1이 칼로리
            arr = new int[N + 1][2];
            for(int i =1;i<=N;i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            dp = new int[N+1][L+1];
            for(int i =1;i<=N;i++){
                for(int j =0;j<=L;j++){
                    // 현재 물건을 못 담는 경우
                    if(j<arr[i][1]){
                        dp[i][j] = dp[i - 1][j];
                    }
                    // 현재 물건을 담을 수 있는 경우
                    else{
                        dp[i][j] = Math.max(dp[i - 1][j - arr[i][1]] + arr[i][0], dp[i - 1][j]);
                    }
                }
            }
            System.out.println("#" + test_case + " "+dp[N][L]);
		}
	}
}