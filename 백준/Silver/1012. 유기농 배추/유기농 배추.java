import java.io.*;
import java.util.*;

public class Main {
    static int M,N,K,count;
    static boolean check[][];
    static int map[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    public static void dfs(int x,int y){
        // 방문 기록
        check[x][y] = true;
        for(int i =0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0&&ny>=0&&nx<M&&ny<N&&map[nx][ny]==1&&!check[nx][ny]){
                dfs(nx, ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            check = new boolean[M][N];
            for(int i =0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]==1&&!check[i][j]){
                        dfs(i,j);
                        // 하나의 탐색이 끝나면 count값 증가
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
            count = 0;
        }
        System.out.println(sb);
    }
}
