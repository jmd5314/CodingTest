import java.io.*;
import java.util.*;

public class Main {
    static int dx[] = {-1,1,0,0,0,0};
    static int dy[] = {0,0,1,-1,0,0};
    static int dz[] = {0,0,0,0,1,-1};
    static int M,N,H;
    static int [][][] box;
    static boolean [][][]check;
    static int[][][] result;
    public static void bfs(List<int[]>indexes){
        Queue<int[]> q = new LinkedList<>();
        for(int[] index:indexes){
            q.add(index);
            check[index[0]][index[1]][index[2]] = true;
        }
        while (!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int now[] = q.poll();
                int nowX = now[0];
                int nowY = now[1];
                int nowZ = now[2];
                for(int j=0;j<6;j++){
                    int nx = nowX + dx[j];
                    int ny = nowY + dy[j];
                    int nz = nowZ + dz[j];
                    if(nx>=0&&ny>=0&&nz>=0&&nx<N&&ny<M&&nz<H&&box[nx][ny][nz]==0&&!check[nx][ny][nz]){
                        q.add(new int[]{nx, ny, nz});
                        result[nx][ny][nz] = result[nowX][nowY][nowZ] + 1;
                        check[nx][ny][nz] = true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<int[]> indexes = new ArrayList<>();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[N][M][H];
        check = new boolean[N][M][H];
        result = new int[N][M][H];
        for(int i =0;i<H;i++){
            for(int j =0;j<N;j++){
                st = new StringTokenizer(br.readLine());
                for(int k =0;k<M;k++){
                    box[j][k][i] = Integer.parseInt(st.nextToken());
                    if(box[j][k][i]==1)
                        indexes.add(new int[]{j, k, i});
                }
            }
        }
        bfs(indexes);
        int max = Integer.MIN_VALUE;
        boolean all = false;
        for(int i =0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(result[j][k][i]>max)
                        max = result[j][k][i];
                    if(box[j][k][i]==0&&!check[j][k][i])
                        all = true;
                }
            }
        }
        if(all)
            System.out.println(-1);
        else
            System.out.println(max);
    }
}