import java.io.*;
import java.util.*;

public class Main {
    // 어차피 더 높은 대나무 숲으로만 이동하기 때문에 check 배열을 따로 둘 필요가 없다
    static int n;
    static int arr[][];
    // dp[i][j]는 arr[i][j]에서 출발할 경우 최댓값을 나타냄
    static int dp[][];
    static int ans = 0;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static int dfs(int x, int y) {
        // dp에 저장된 값이 있는 경우 이미 그 경로를 탐색한 것이기 때문에 dp 값을 반환
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        // x y에서 시작할때 한칸은 무조건 가능하므로 1로 초기화
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] > arr[x][y]) {
                /* 상하 좌우 중 가장 오래 생존할 수 있는 기간을 선택
                 * dp[x][y] = Max(dp[nx][ny])+1
                 */
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
            }
        }
        return dp[x][y];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        dp = new int[n][n];
        for(int i =0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                ans = Math.max(ans, dfs(i, j));
            }
        }
        System.out.println(ans);
    }
}