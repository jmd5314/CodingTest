import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static char [][] arr;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static boolean check[][];
    static int count = 0;
    static boolean dp[][];

    public static boolean dfs(int x, int y) {
        check[x][y] = true;
        int nx = 0;
        int ny = 0;
        if (arr[x][y] == 'U') {
            nx = x + dx[0];
            ny = y + dy[0];
        } else if (arr[x][y] == 'R') {
            nx = x + dx[1];
            ny = y + dy[1];
        } else if (arr[x][y] == 'D') {
            nx = x + dx[2];
            ny = y + dy[2];
        } else {
            nx = x + dx[3];
            ny = y + dy[3];
        }
        // 경계밖이면 탈출 가능하므로 현재 경로의 dp 값을 true 로 저장하고 return
        if(nx < 0 || ny < 0 || nx >= N || ny >=M){
            return dp[x][y] = true;
        }
        else{
            if(!check[nx][ny]){
                return dp[x][y] = dfs(nx, ny);
            }
            /* dp[x][y] = false 로 두면 안되는 이유
             * 이미 방문한 (nx,ny)가 탈출 가능한 경로 일 수 있기때문!
             * 탈출 가능하지 않은 경로라면 처음 dp에 false 값이 초기화 되있고,
             * 탈출 가능한 경로라면 그 이전의 dfs 탐색 중 true 값으로 초기화 되있을 것임
             */
            else {
                return dp[x][y] = dp[nx][ny];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        check = new boolean[N][M];
        dp = new boolean[N][M];
        for(int i =0;i<N;i++) {
            String s = br.readLine();
            for(int j = 0;j<M;j++){
                arr[i][j] = s.charAt(j);
            }
        }
        for(int i =0;i<N;i++){
            for (int j = 0; j < M; j++) {
                //방문한 적이 있고, 가능하면 count + 1
                if (check[i][j]&&dp[i][j]) {
                    count++;
                }
                // 방문한 적 없으면 dfs 실행 후 가능하면 count + 1
                else if(!check[i][j]){
                    if(dfs(i,j))
                        count++;
                }
            }
        }
        System.out.println(count);
    }
}