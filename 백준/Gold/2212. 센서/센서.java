import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] sensor = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i<N;i++){
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        // 센서 위치 오름 차순 정렬
        Arrays.sort(sensor);
        // 각 센서 사이의 거리 배열 내림차순 정렬을 위해 Integer 타입 배열로 정의
        Integer [] diff = new Integer[N-1];
        for(int i =0;i<N-1;i++){
            diff[i] = sensor[i + 1] - sensor[i];
        }
        Arrays.sort(diff, Collections.reverseOrder());
        /* K개의 구간으로 나누면, 각 구간 사이가 K-1개 생기고 각 사이의 차이가 최대가 되도록 선택해야 함
         * 그러므로 내림차순으로 정리한뒤 가장 값이 큰 거리 K-1개를 빼면 나머지 값을 더하면 됨
         * 0 부터 K 번째 까지의 값을 빼고 나머지 거리 차이들을 더해줌
         */
        int sum = 0;
        for(int i =K-1;i<N-1;i++){
            sum += diff[i];
        }
        System.out.println(sum);
    }
}