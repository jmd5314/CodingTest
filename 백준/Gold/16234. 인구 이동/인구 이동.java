import java.io.*;
import java.util.*;

public class Main {
    public static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N,L,R;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static boolean[][] check;
    static int[][] A;
    static List<Node> list = new ArrayList<>();
    static boolean isMove;
    static int count = 0;
    public static void bfs(int x,int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        check[x][y] = true;
        list.add(new Node(x, y));
        while (!q.isEmpty()){
            Node node = q.poll();
            x = node.x;
            y = node.y;
            for(int i =0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0&&ny>=0&&nx<N&&ny<N){
                    if (!check[nx][ny] && Math.abs(A[x][y] - A[nx][ny]) >= L && Math.abs(A[x][y] - A[nx][ny]) <= R) {
                        check[nx][ny] = true;
                        // 한번이라도 이동했으면 isMove가 true가 됨
                        isMove = true;
                        list.add(new Node(nx, ny));
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
        //bfs 로 다 탐색한 곳은 모두 같이 인구이동이 일어남
        int sum = 0;
        for(int i =0;i<list.size();i++){
            Node node = list.get(i);
            sum += A[node.x][node.y];
        }
        for(int i =0;i<list.size();i++){
            Node node = list.get(i);
            A[node.x][node.y] = sum / list.size();
        }
        list.clear();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true){
            isMove = false;
            // 방문 체크 초기화
            check = new boolean[N][N];
            for(int i =0;i<N;i++){
                for(int j =0;j<N;j++){
                    //이미 bfs 로 탐색한 곳은 방문 체크 되어 있을 것이고, 다른 구역을 탐색할때 다시 false로 초기화 됨
                    if(!check[i][j])
                        bfs(i, j);
                }
            }
            // 모든 땅 탐색했을때 이동이 없었으면 더이상 이동이 일어나지 않으므로 break
            if(!isMove)
                break;
            // 이동이 있었다면 하루 추가
            else
                count++;
        }
        System.out.println(count);
    }
}