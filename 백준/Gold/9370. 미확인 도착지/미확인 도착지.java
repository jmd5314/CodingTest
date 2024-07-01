import java.util.*;
import java.io.*;
public class Main {
    public static class Node{
        int e;
        int w;
        public Node(int e,int w){
            this.e = e;
            this.w = w;
        }
    }
    public static int dijkstra(int start,int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> {
            return o1.w - o2.w;
        }));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        // 시작점은 거리 0
        dist[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowE = now.e;
            int nowW = now.w;
            // 만약 현재 노드까지의 거리가 기록된 거리보다 길면 해당 경로는 무시
            if(dist[nowE]<nowW)
                continue;
            for(Node node:graph[nowE]){
                int nextE = node.e;
                int nextW = node.w;
                int cost = nowW + nextW;
                if(cost<dist[nextE]){
                    dist[nextE] = cost;
                    pq.add(new Node(nextE, cost));
                }
            }
        }
        return dist[end];
    }
    static  List<Node>[] graph;
    static final int INF = 50000000;
    static boolean [] check ;
    static List<Integer> answerList;
    static int n,m,t,s,g, h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            graph = new List[n + 1];
            for(int i =1;i<=n;i++){
                graph[i] = new ArrayList<>();
            }
            check = new boolean[n + 1];
            answerList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            for(int i =0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                // 양방향 저장
                graph[a].add(new Node(b, d));
                graph[b].add(new Node(a, d));
            }
            int[] dst = new int[t];
            for(int i =0;i<t;i++) {
                dst[i] = Integer.parseInt(br.readLine());
            }
            for (int i =0;i<dst.length;i++){
                // s에서 목적지까지 최소 거리와 s->g + g->h h-> dst 혹은 s->h + h->g g->dst 거리 중 최소 거리를 비교
                int answer = dijkstra(s, dst[i]);
                int answerA = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, dst[i]);
                int answerB = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, dst[i]);
                if (answer == Math.min(answerA, answerB)) {
                    answerList.add(dst[i]);
                }
            }
            Collections.sort(answerList);
            for(Integer ans:answerList){
                sb.append(ans).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}