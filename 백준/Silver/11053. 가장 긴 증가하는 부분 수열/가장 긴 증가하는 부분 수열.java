import java.util.*;
public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int num[] = new int[N];
        int dp[] = new int[N];
        for(int i =0;i<N;i++){
            num[i] = sc.nextInt();
        }
        for(int i =0;i<N;i++){
            //해당 인덱스의 값을 가진 수열이 기본값이기 때문에 1
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                //j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1값보다 작은 경우
                if(num[j]<num[i]&&dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1; //j번째 원소의 +1값이 i번째 dp가 된다
                }
            }
        }
        int max = 1;
        for(int i =0;i<N;i++){
            if(dp[i]>max)
                max = dp[i];
        }
        System.out.println(max);
    }
}