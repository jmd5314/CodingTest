import java.io.*;
import java.util.*;

public class Main {
    static int M,N;
    static int [][] map,dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static int dfs(int x,int y){
        // 현재 위치가 끝점일 경우 1을 반환
        if(x==M-1&&y==N-1){
            return 1;
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        dp[x][y] = 0; // 현재 위치에서 끝점까지 도달하는 경로의 개수를 0으로 초기화
        for(int i =0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0&&ny>=0&&nx<M&&ny<N){
                // 만약 현재 위치 보다 다음 점이 높이가 더 낮으면 다음 점에서 끝점까지의 dfs 경로를 더해준다
                if(map[x][y]>map[nx][ny])
                    dp[x][y] += dfs(nx, ny);
            }
        }
        return dp[x][y];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[M][N];
        for(int i =0;i<M;i++){
            for(int j=0;j<N;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0));
    }
}