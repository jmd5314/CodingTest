import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[][] point = new long[N+1][2];
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            point[i][0] = Long.parseLong(st.nextToken());
            point[i][1] = Long.parseLong(st.nextToken());
        }
        point[N][0] = point[0][0];
        point[N][1] = point[0][1];
        long sum_a = 0;
        long sum_b = 0;
        // 신발끈 공식을 이용하여 다각형의 면적을 구함
        for(int i =0;i<N;i++){
            sum_a += point[i][0] * point[i + 1][1];
            sum_b += point[i + 1][0] * point[i][1];
        }
        double result = Math.abs(sum_a - sum_b) / 2.0;
        System.out.println(String.format("%.1f", result));
    }
}