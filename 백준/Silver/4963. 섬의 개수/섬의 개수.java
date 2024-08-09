import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] arr;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int count;

    public static void dfs(int x, int y) {
        arr[x][y] = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < h && ny < w && arr[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            arr = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}