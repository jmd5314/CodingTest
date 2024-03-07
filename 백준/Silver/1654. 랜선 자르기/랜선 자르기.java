import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        long max = 0;
        // 입력 받으면서 max 값을 갱신
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        // 반드시 max 에서 +1 값이어야 함
        max++;

        long min = 0;
        long mid = 0;

        while (min < max) {
            mid = (max + min) / 2;
            long count = 0;

            // 구해진 중간 길이로 잘라서 총 몇 개인지 카운트
            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }
            //mid 길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면 자르고자 하는 길이 줄이기 위해 최대 길이를 줄임
            if(count < N) {
                max = mid;
            }
            // 반대의 경우 최소 길이를 늘림
            else {
                min = mid + 1;
            }
        }
        // UpperBound 로 얻어진 값(min)에 -1이 최대 길이가 됨
        System.out.println(min - 1);
    }
}