import java.io.*;
import java.util.*;
public class Main {
    static int N,M,V;
    static List<Integer>[] graph;
    static boolean check[];
    static StringBuilder sbd = new StringBuilder();
    static StringBuilder sbb = new StringBuilder();

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] = true;
        while (!q.isEmpty()){
            int now = q.poll();
            sbb.append(now + " ");
            for(int next:graph[now]){
                if(!check[next]){
                    q.add(next);
                    check[next] = true;
                }
            }
        }

    }
    public static void dfs(int v){
        check[v] = true;
        sbd.append(v + " ");
        for(int next:graph[v]){
            if(!check[next]){
                dfs(next);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        check = new boolean[N + 1];
        for(int i =1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        // 오름차순 정렬 탐색할 수 있는 곳이 여러 곳일 경우 낮은 숫자부터 탐색해야 하기때문!
        for(int i =1;i<=N;i++){
            Collections.sort(graph[i]);
        }
        dfs(V);
        System.out.println(sbd);
        check = new boolean[N + 1];
        bfs(V);
        System.out.println(sbb);
    }
}