import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int [][] map;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static int ans = Integer.MIN_VALUE;
    // 벽을 3개 칠 수 있는 모든 경우 다 탐색
    public static void dfs(int cnt){
        // 벽을 3개 친 경우 bfs
        if(cnt==3){
            bfs();
            return;
        }
        for(int i =0;i<N;i++){
            for(int j =0;j<M;j++){
                // 빈칸인 경우 벽을 치고 dfs
                if(map[i][j]==0){
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        // map 을 그대로 쓰면 다음 bfs 를 할때 남기때문에 copy 배열 생성
        int[][] copy = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        // 바이러스가 있는 곳은 모두 큐에 넣음
        for(int i =0;i<N;i++){
            for(int j = 0;j<M;j++){
                copy[i][j] = map[i][j];
                if(copy[i][j]==2)
                    q.add(new int[]{i, j});
            }
        }
        while (!q.isEmpty()){
            int[] now = q.poll();
            copy[now[0]][now[1]] = 2;
            for(int i =0;i<4;i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0&&ny>=0&&nx<N&&ny<M&&copy[nx][ny]==0){
                    q.add(new int[]{nx, ny});
                }
            }
        }
        int count = 0;
        for(int i =0;i<N;i++){
            for(int j = 0;j<M;j++){
                if (copy[i][j] == 0) {
                    count++;
                }
            }
        }
        ans = Math.max(count, ans);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(ans);
    }
}