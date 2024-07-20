import java.io.*;
import java.util.*;

public class Main {
    static int N;
    // 퍼센트를 동서남북으로 입력 받기 때문에 편의상 동서남북
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static double percent[];
    static double ans = 0.0;
    static boolean check[][];
    public static void dfs(int x, int y, int d,double p) {
        if(d==N){
            ans += p;
            return;
        }
        check[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            /*이동 경로가 단순한 것은 한번 방문한 곳을 가지 않는다는 것을 의미
             * 배열 크기를 갈 수 있는 최대 크기까지 해놨기 때문에 인덱스 범위검사는 할 필요가 없음
             */
            if(!check[nx][ny]){
                // 갈 수 있는 방향은 해당 방향으로 갈 확률을 곱해줌
                dfs(nx, ny, d + 1, p * percent[i]);
            }
        }
        check[x][y] = false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        percent = new double[4];
        // 음수좌표로도 갈 수 있기 때문에 시작 위치를 (N,N)으로 두고 2N+1 로 초기화
        check = new boolean[2 * N + 1][2 * N + 1];
        for(int i =0;i<4;i++){
            percent[i] = (double) Integer.parseInt(st.nextToken()) / 100.0;
        }
        dfs(N, N, 0, 1.0);
        System.out.println(ans);
    }
}