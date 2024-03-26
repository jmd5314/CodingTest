import java.io.*;
import java.util.*;

public class Main {
    static int n,m,sx,sy;
    static int[][]map;
    static int[][]result;
    static boolean[][]check;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void bfs(int x,int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        check[x][y] = true;
        while (!q.isEmpty()){
            int []now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            for(int i =0;i<4;i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if(nx>=0&&ny>=0&&nx<n&&ny<m&&map[nx][ny]==1&&!check[nx][ny]){
                    q.add(new int[]{nx, ny});
                    result[nx][ny] = result[nowX][nowY]+1;
                    check[nx][ny] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = new int[n][m];
        check = new boolean[n][m];
        for(int i =0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    sx = i;
                    sy = j;
                }
            }
        }
        bfs(sx,sy);
        // 만약 갈 수 있는 땅인데 도달한적이 없다면 -1로 초기화 해줌
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(result[i][j]==0){
                    if(map[i][j]==1)
                        result[i][j] =-1;
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}