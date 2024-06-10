import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int count = 0;
        if(N<3){
            System.out.println(0);
            System.exit(0);
        }
        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        for(int i =0;i<N;i++){
            int start = 0;
            int end = N - 1;
            int key = num[i];
            // 투 포인터로 현재 값보다 작은 값들의 합 탐색
            while (start<end){
                if(num[start]+num[end]==key){
                    // 자기 자신은 제외 해야함
                    if (start != i && end != i) {
                        count++;
                        break;
                    }
                    /* 자기 자신을 포함한 경우 각각에 맞게 index 조정
                     * start = i 인 경우 start 값을 변경해줘야 갯수를 제대로 셀 수 있음
                     * ex) 0 0 0 인 경우 start = i일때 end-- 해주면 start 가 계속 그대로이므로 count 되지 않음
                     */
                    else if (start == i) {
                        start++;
                    }
                    else{
                        end--;
                    }
                }
                else if(num[start]+num[end]<key){
                    start++;
                }
                else
                    end--;
            }
        }
        System.out.println(count);
    }
}