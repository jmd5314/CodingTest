import java.io.*;
import java.util.*;

public class Main {
    static int N,M, K;
    static char[][] arr;
    static String word;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int [][][] dp;
    static int count = 0;
    public static void dfs(int x, int y, int d) {
        // 단어의 마지막 글자까지 탐색한 것이므로 해당 글자 dp 값 1로 초기화
        if (d == word.length() - 1) {
            dp[x][y][d] = 1;
        }
        // 이미 방문한 곳이므로 return
        if(dp[x][y][d] != -1)
            return ;
        // 이제 방문 했으므로 0으로 초기화
        dp[x][y][d] = 0;
        for(int i = 1;i<=K;i++){
            for(int j =0;j<4;j++){
                int nx = x + dx[j] * i;
                int ny = y + dy[j] * i;
                // 인덱스 범위 값을 만족하고, 다음 문자가 해당 자리수에 맞는지 확인
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == word.charAt(d + 1)) {
                    dfs(nx, ny, d + 1);
                    dp[x][y][d] += dp[nx][ny][d + 1];
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for(int i =0;i<N;i++){
            String s = br.readLine();
            for(int j =0;j<M;j++){
                arr[i][j] = s.charAt(j);
            }
        }
        word = br.readLine();
        /* dp[a][b][c]
         * arr[a][b]가 c번째 에 올때의 dp 값
         */
        dp = new int[N][M][word.length()];
        // dp의 방문 여부를 위해 -1로 초기화
        for(int i =0;i<N;i++){
            for(int j =0;j<M;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        for(int i =0;i<N;i++){
            for(int j=0;j<M;j++){
                // 단어의 첫글자와 같은 경우 해당 칸부터 dfs 시작
                if (arr[i][j] == word.charAt(0)) {
                    dfs(i, j, 0);
                    count += dp[i][j][0];
                }
            }
        }
        System.out.println(count);
    }
}