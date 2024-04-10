import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    // 북동남서 
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int [][] room;
    static int count = 0;
    public static void clean(int r,int c,int d){
        int dir = d;
        // 청소를 한 칸에 오는 경우도 있기때문에 0인 경우를 2로 바꾸고 카운트
        if(room[r][c]==0){
            room[r][c]=2;
            count++;
        }
        for(int i =0;i<4;i++){
            // 반시계 90도 회전 방향
            int nd = (dir + 3) % 4;
            int nx = r + dx[nd];
            int ny = c + dy[nd];
            // 청소되지 않은 빈 칸이 있다면 체크
            if(nx>=0&&ny>=0&&nx<N&&ny<M&&room[nx][ny]==0){
                clean(nx, ny, nd);
                return;
            }
            // 현재 방향 번경
            dir = nd;
        }
        // 청소되지 않은 빈 칸이 없다면
        int backDir = (d + 2) % 4;
        int nx = r + dx[backDir];
        int ny = c + dy[backDir];
        // 뒤가 벽이 아닌 경우 이동
        if(nx>=0&&ny>=0&&nx<N&&ny<M&&room[nx][ny]!=1){
            clean(nx, ny, d);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<M;j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(r, c, d);
        System.out.println(count);
    }
}