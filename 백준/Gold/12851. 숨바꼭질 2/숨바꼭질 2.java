import java.util.*;
import java.io.*;
public class Main {
    static int N, K,count=0;
    static final int max = 100000;
    static int dx[] = {-1, 1, 2};
    static int[] point = new int[max+1];
    public static void bfs(int N){
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        while (!q.isEmpty()){
            int now = q.poll();
            if (now == K) {
                break;
            }
            for(int i =0;i<3;i++){
                int nx = now;
                if(i<2)
                    nx += dx[i];
                else
                    nx *= dx[i];
                // nx가 범위 밖에 있거나 방문한 적이 있는데, 지금 방문하는 거리가 이전 값보다 클 경우 넘어감
                if (nx<0 || nx>max|| (point[nx]!=0 &&point[now] + 1> point[nx]))
                    continue;
                point[nx] = point[now] + 1;
                q.add(nx);
                if(nx==K)
                    count++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        // 만약 수빈이와 동생의 위치가 같다면
        if(N==K){
            System.out.println(point[K]);
            System.out.println(1);
            System.exit(0);
        }
        bfs(N);
        System.out.println(point[K]);
        System.out.println(count);
    }
}