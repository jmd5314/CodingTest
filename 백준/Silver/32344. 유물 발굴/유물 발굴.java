import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][4];
        for (int i = 1; i <= N; i++) {
            arr[i][0] = Integer.MAX_VALUE;
            arr[i][1] = Integer.MIN_VALUE;
            arr[i][2] = Integer.MAX_VALUE;
            arr[i][3] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[a][0] = Math.min(v, arr[a][0]);
            arr[a][1] = Math.max(v, arr[a][1]);
            arr[a][2] = Math.min(h, arr[a][2]);
            arr[a][3] = Math.max(h, arr[a][3]);
        }
        int idx = 0;
        long max = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[i][0] == Integer.MAX_VALUE) {
                continue;
            }
            long area = (long) (arr[i][1] - arr[i][0] + 1) * (long) (arr[i][3] - arr[i][2] + 1);
            if (area > max) {
                max = area;
                idx = i;
            }
        }
        System.out.println(idx + " " + max);
    }
}