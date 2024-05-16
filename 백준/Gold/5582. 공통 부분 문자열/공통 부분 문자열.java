import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        // dp[i][j] = dp[i-1][j-1]+1의 계산의 편의를 위해 각 문자열보다 1씩 더 배열을 할당받음
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        // max 는 무조건 0으로 초기화 해야함 공통되는 문자열이 없는 경우가 있기때문에 0또한 정답이 될 수 있음
        int max = 0;
        for(int i =1;i<=str1.length();i++){
            for(int j =1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    /* 만약 서로 B인 것으로 같고 만약 이전 문자가 A 였다면
                     * 대각선 왼쪽 위의 값 은 서로 A로 같아서 1일테고 거기에 +1을 하면 됨
                     */
                    dp[i][j] = dp[i-1][j-1]+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}