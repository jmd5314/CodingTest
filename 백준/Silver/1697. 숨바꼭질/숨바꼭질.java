import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static int point[] = new int[100001] ;
    static boolean check[] = new boolean[100001];
    static int dx[] = {-1, 1};
    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        check[x] = true;
        while (!q.isEmpty()){
            int nowX = q.poll();
            for(int i =0;i<3;i++){
                int nx;
                if(i<2){
                    nx = nowX + dx[i];
                }
                else{
                    nx = 2*nowX;
                }
                if(nx>=0&&nx<=100000&&!check[nx]){
                    q.add(nx);
                    point[nx] = point[nowX]+1;
                    check[nx] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(N==K){
            System.out.println(0);
        }
        else{
        bfs(N);
        System.out.println(point[K]);
        }
    }
}