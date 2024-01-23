import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int wire[][] = new int[N][2];
        int dp[]= new int[N];
        for(int i =0;i<N;i++){
            wire[i][0] = sc.nextInt();
            wire[i][1] = sc.nextInt();
        }
        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i =0;i<N;i++){
            dp[i] = 1; //기본 값은 1
            //i보다 작은 j값들 중 i의 B 전봇대 값이 j의 B 전봇대 값보다 커야한다
            for(int j=0;j<i;j++){
                if(wire[i][1]>wire[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);// 해당 j 이전에 저장된 다른 j값이 더 클 수 있기떄문에 둘 중 큰수를 택한다
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i =0;i<N;i++){
            if (max<dp[i])
                max = dp[i];
        }
        System.out.println(N-max);
    }
}