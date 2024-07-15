import java.io.*;
import java.util.*;

public class Main {
    public static class Node{
        int e;
        int w;
        public Node(int e,int w){
            this.e = e;
            this.w = w;
        }
    }
    static int N,M, X;
    static final int INF = Integer.MAX_VALUE;
    static int [] dist1,dist2;
    public static int [] dijkstra(List<Node>[] graph){
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> {
            return o1.w - o2.w;}));
        pq.add(new Node(X, 0));
        boolean[] check = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[X] = 0;
        while (!pq.isEmpty()){
            Node node = pq.poll();
            int nowE = node.e;
            if(!check[nowE]){
                check[nowE] = true;
                for(int i = 0;i<graph[nowE].size();i++){
                    Node next = graph[nowE].get(i);
                    if (!check[next.e] && dist[next.e] > dist[nowE] + next.w) {
                        dist[next.e] = dist[nowE] + next.w;
                        pq.add(new Node(next.e, dist[next.e]));
                    }
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        List<Node> [] graph1 = new List[N + 1];
        List<Node> [] graph2 = new List[N + 1];

        for(int i =1;i<=N;i++){
            graph1[i] = new ArrayList<>();
            graph2[i] = new ArrayList<>();
        }
        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph1[s].add(new Node(e, w));
            graph2[e].add(new Node(s, w));
        }
        dist1 = dijkstra(graph1);
        dist2 = dijkstra(graph2);
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }
        System.out.println(ans);
    }
}