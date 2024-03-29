import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int map[][];
    static int result[][];
    static boolean check[][][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    public static void bfs(int x,int y){
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        result[x][y] = 1;
        check[x][y][0] = true;
        while (!q.isEmpty()){
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowC = now[2];
            for(int i =0;i<4;i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if(nx>=1&&nx<=N&&ny>=1&&ny<=M){
                    // 다음 칸에 벽이 있을 경우
                    if(map[nx][ny]==1){
                        if(nowC==0&&!check[nx][ny][1]){ // 벽을 부순지 체크, 그 벽을 방문한적이 있는지 체크
                            check[nx][ny][1] = true;
                            result[nx][ny] = result[nowX][nowY] + 1;
                            q.add(new int[]{nx, ny, 1}); // 벽을 부수고 이동한 경우를 큐에 추가
                        }
                    }
                    //벽이 아닐경우 벽을 부순 여부에 따른 방문을 했는지 체크
                    else{
                        //해당 칸을 방문 안했을때
                        if(!check[nx][ny][nowC]){
                            check[nx][ny][nowC] = true;
                            result[nx][ny] = result[nowX][nowY] + 1;
                            q.add(new int[]{nx, ny, nowC});
                        }
                    }
                    if(nx==N&&ny==M){
                        System.out.println(result[nx][ny]);
                        System.exit(0);
                    }
                }
            }
        }
        // 도달을 못했으므로 -1 출력
        System.out.println(-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N + 1][M + 1][2];
        map = new int[N + 1][M + 1];
        result = new int[N + 1][M + 1];
        for(int i =1;i<=N;i++){
            String s = br.readLine();
            for(int j=1;j<=M;j++){
                map[i][j] = s.charAt(j-1) - '0';
            }
        }
        if(N==1&&M==1){
            System.out.println(1);
            System.exit(0);
        }
        bfs(1, 1);
    }
}