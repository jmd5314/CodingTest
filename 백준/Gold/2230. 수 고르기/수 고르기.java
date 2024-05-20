import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        for(int i =0;i<N;i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);
        int start = 0;
        int end = 0;
        int result = Integer.MAX_VALUE;
        while (end<N){
             // 두 수의 차가 M 보다 작으면 끝 점을 한칸 이동해 차가 더 커지게 만듦
            if(num[end]-num[start]<M){
                end++;
            }
            // 두 수의 차가 M이면 정답은 M 이므로 break
            else if(num[end]-num[start]==M){
                result = M;
                break;
            }
            // 두 수의 차가 M보다 크면 시작 점을 한칸 이동해 차가 더 작아지게 만듦
            else {
                // M보다 큰 수 중 가장 작은 값으로 초기화 해줘야 함
                result = Math.min(result, num[end] - num[start]);
                start++;
            }
        }
        System.out.println(result);
    }
}