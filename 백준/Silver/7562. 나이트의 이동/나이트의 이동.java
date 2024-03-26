import java.io.*;
import java.util.*;

public class Main {
    static int l,sx,sy,gx,gy;
    static int chess[][];
    static boolean check[][];
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    public static void bfs(int x,int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        check[x][y] = true;
        while (!q.isEmpty()){
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            for(int i =0;i<8;i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if(nx>=0&&ny>=0&&nx<l&&ny<l&&!check[nx][ny]){
                    q.add(new int[]{nx,ny});
                    chess[nx][ny] = chess[nowX][nowY]+1;
                    check[nx][ny] = true;
                    if(nx==gx&&ny==gy){
                        System.out.println(chess[nx][ny]);
                        return;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            l = Integer.parseInt(br.readLine());
            chess = new int[l][l];
            check = new boolean[l][l];
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            gx = Integer.parseInt(st.nextToken());
            gy = Integer.parseInt(st.nextToken());
            if(sx==gx&&sy==gy){
                System.out.println(0);
            }
            else{
            bfs(sx,sy);
            }
        }
    }
}