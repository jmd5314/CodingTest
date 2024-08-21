import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L, K;
    static List<int[]> list = new ArrayList<>();

    public static int countStars(int x, int y) {
        int cnt = 0;
        for (int k = 0; k < K; k++) {
            int cx = list.get(k)[0];
            int cy = list.get(k)[1];
            if (x <= cx && cx <= x + L && y <= cy && cy <= y + L) {
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y});
        }
        int count = 0;
        for (int i = 0; i < K; i++) {
            int x = list.get(i)[0];
            for (int j = 0; j < K; j++) {
                int y = list.get(j)[1];
                count = Math.max(countStars(x, y), count);
            }
        }
        System.out.println(K-count);
    }
}