import java.io.*;
import java.util.*;

public class Main {
    static int dice[] = {1, 2, 3, 4, 5, 6};
    static int point[] = new int[101];
    static boolean check[] = new boolean[101];
    static HashMap<Integer,Integer> map;

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        check[x] = true;
        while (!q.isEmpty()){
            int now = q.poll();
            for(int i =0;i<6;i++){
                int nx = now + dice[i];
                if(nx>0&&nx<=100&&!check[nx]){
                    check[nx] = true;
                    point[nx] = point[now] + 1;
                    if (map.containsKey(nx)) {
                        int val = map.get(nx);
                        if(!check[val]){
                            check[val] = true;
                            point[val] = point[nx];
                            q.add(val);
                        }
                    } else {
                        q.add(nx);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i =0;i<N+M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map.put(u, v);
        }
        bfs(1);
        System.out.println(point[100]);
    }
}
