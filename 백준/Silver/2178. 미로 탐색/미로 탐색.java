import java.io.*;
import java.util.*;

public class Main {
    static int M,N;
    static boolean check[][];
    static int map[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    public static void bfs(int x,int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        while(!q.isEmpty()){
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            for(int i =0;i<4;i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if (nx >= 1 && ny >= 1 && nx <= N && ny <= M && map[nx][ny] == 1 && !check[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    // 다음 이동 칸에 이전 칸의 수+1 을 해준다
                    map[nx][ny] = map[nowX][nowY]+1;
                    check[nx][ny] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        for(int i =1;i<=N;i++){
            String s = br.readLine();
            for(int j=1;j<=M;j++){
                map[i][j] = s.charAt(j - 1) - '0';
            }
        }
        check = new boolean[N + 1][M + 1];
        check[1][1] = true;
        bfs(1, 1);
        System.out.println(map[N][M]);
    }
}