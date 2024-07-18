import java.io.*;
import java.util.*;

public class Main {
    public static void dfs(int x, int y, int depth) {
        if(depth>max)
            max = depth;
        alpha[arr[x][y]] = true;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C  && !alpha[arr[nx][ny]]) {
                dfs(nx, ny, depth + 1);
            }
        }
        alpha[arr[x][y]] = false;
    }
    static int max = 0;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    // 문자가 아닌 숫자로 저장 A : 0 ~ Z: 26
    static int arr[][];
    static int R,C;
    // 알파벳이 나온적이 있는지 여부에 따라 이미 방문한 알파벳은 어차피 방문 하지 않으므로 check 배열을 따로 둘 필요가 없음
    static boolean alpha[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        alpha = new boolean[26];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j) - 'A';
            }
        }
        dfs(0, 0, 1);
        System.out.println(max);
    }
}