import java.io.*;
import java.util.*;

public class Main {
    public static void bfs(List<int[]> indexes){
        Queue<int[]> q = new LinkedList<>();
        for(int[] index:indexes){
            q.add(index);
            check[index[0]][index[1]] = true;
        }
        while (!q.isEmpty()){
            int size = q.size();
            // 큐의 사이즈를 받는 이유 : 리스트의 사이즈로 for 문을 돌리면 비어있는 큐에서 꺼내려고 시도하게 되어버림
            for(int i =0;i<size;i++){
                int now[] = q.poll();
                int nowX = now[0];
                int nowY = now[1];
                for(int j =0;j<4;j++){
                    int nx = nowX + dx[j];
                    int ny = nowY + dy[j];
                    if(nx>=0&&ny>=0&&nx<N&&ny<M&&box[nx][ny]==0&&!check[nx][ny]){
                        q.add(new int[]{nx, ny});
                        result[nx][ny] = result[nowX][nowY] + 1;
                        check[nx][ny] = true;
                    }
                }
            }
        }
    }

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int M,N;
    static int box[][];
    static int result[][];
    static boolean check[][];
    static boolean all;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<int[]> indexes = new ArrayList<>();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        check = new boolean[N][M];
        result = new int[N][M];
        all = false;
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                // 익은 토마토들 리스트에 추가
                if(box[i][j]==1)
                    indexes.add(new int[]{i, j});
            }
        }
                bfs(indexes);
                int max = Integer.MIN_VALUE;
                for(int i =0;i<N;i++){
                    for (int j = 0; j < M; j++) {
                        // 만약 방문한 적이 없는 익지 않은 토마토가 존재한다면, 전체 토마토가 익지 않은 것이므로 체크
                        if (!check[i][j]&&box[i][j]==0)
                            all = true;
                        if (result[i][j] > max) {
                            max = result[i][j];
                        }
                    }
                }
                if(all)
                    System.out.println(-1);
                // 모든 토마토가 익어있는 경우는 어차피 처음에 익어있는 토마토들의 result 값은 0이고, 변하지 않으므로 최댓값은 0으로 출력됨
                else
                    System.out.println(max);
        }
    }