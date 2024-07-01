import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long [] ans = new long [3];
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int mid = 0;
        int end = 0;
        long min = Long.MAX_VALUE;
        /* 투 포인터 응용 start 를 0~n-2 범위로 탐색하고 mid 와 end 값 설정을 투포인터로 찾음
         * 시간 복잡도는 O(N^2)
         */
        for(int i=0;i<N-2;i++){
            start = i;
            mid = i+1;
            end = N - 1;
            while (mid<end){
                long sum = arr[start] + arr[mid] + arr[end];
                if(Math.abs(sum)<Math.abs(min)){
                    min = sum;
                    ans[0] = arr[start];
                    ans[1] = arr[mid];
                    ans[2] = arr[end];
                }
                if(sum==0)
                    break;
                else if(sum<0)
                    mid++;
                else
                    end--;
            }
        }
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}