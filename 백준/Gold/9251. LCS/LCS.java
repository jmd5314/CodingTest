import java.util.*;
public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        char[] str1 = sc.nextLine().toCharArray();
        char[] str2 = sc.nextLine().toCharArray();
        int l1 = str1.length;
        int l2 = str2.length;
        int dp[][] = new int[l1 + 1][l2 + 1];
        for(int i =1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                // 만약 (i-1)과 (j-1)번째 문자가 서로 같으면 dp[i-1][j-1] +1을 더해준다.
                if(str1[i-1]==str2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                // 같지 않으면 dp[i-1][j] 와 dp[i][j-1] 중 더 높은 값으로 갱심
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[l1][l2]);
    }
}