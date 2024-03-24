import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<int[][]>> graph = new ArrayList<>();
    static int N,cnt;
    static boolean check[][];
    static int map[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static List<Integer> result;
    public static void dfs(int x,int y){
        // 해당 집 방문 표시
        check[x][y] = true;
        for(int i =0;i<4;i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !check[nx][ny] && map[nx][ny] == 1) {
                cnt++;
                dfs(nx, ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new ArrayList<>();
        map = new int[N][N];
        check = new boolean[N][N];
        cnt =1; // 단지 내의 아파트 갯수 1로 초기화
        for(int i =0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        for(int i =0;i<N;i++){
            for(int j=0;j<N;j++){
               // 만약 집이 있는 곳에 check 가 되어있지 않다면
                if(map[i][j]==1&&!check[i][j]){
                    // 해당 집부터 dfs
                    dfs(i,j);
                    result.add(cnt);
                    // 다음 단지 아파트 갯수를 위해 cnt 1로 초기화
                    cnt = 1;
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for(int i =0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}