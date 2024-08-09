import java.io.*;

public class Main {
    static int N, K;
    static int[][] arr;

    public static void snail() {
        int x = N / 2;
        int y = N / 2;
        int d = 1;
        int l = 1;
        while (true) {
            for (int i = 0; i < l; i++) {
                arr[x--][y] = d++;
            }
            if (d -1 == N * N) {
                break;
            }
            for (int i = 0; i < l; i++) {
                arr[x][y++] = d++;
            }
            l++;
            for (int i = 0; i < l; i++) {
                arr[x++][y] = d++;
            }
            for (int i = 0; i < l; i++) {
                arr[x][y--] = d++;
            }
            l++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        snail();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
                if (arr[i][j] == K) {
                    x = i+1;
                    y = j+1;
                }
            }
            sb.append("\n");
        }
        sb.append(x + " " + y);
        System.out.println(sb);
    }
}