import java.util.*;
import java.io.*;
class Solution
{
    static int N;
    static int arr[];
    static int dp[];
    static int ans;
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            dp = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i =0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < N; i++) {
                // 자기 자신만 가지는 부분 수열
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    // 0부터 현재 값보다 작은 값 탐색
                    if (arr[j] < arr[i]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
            }
            ans = 0;
            for(int i =0;i<N;i++){
                if(dp[i]>ans)
                    ans = dp[i];
            }
            System.out.println("#" + test_case + " " +ans);
		}
	}
}