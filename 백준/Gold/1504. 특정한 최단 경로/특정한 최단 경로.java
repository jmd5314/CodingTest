import java.io.*;
import java.util.*;

public class Main {
    static int INF = 200000001; // 간선의 최대 값 * 거리 == 200000000
    static int N,E;
    static List<Node>[] graph ;
    static boolean[] check;
    static class Node{
        int end;
        int weight;
        public Node(int end,int weight){
            this.end = end;
            this.weight = weight;
        }
    }
    public static int dijkstra(int start,int end){
        PriorityQueue<Node> q = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
        int[] dist = new int[N + 1];
        for(int i =1;i<=N;i++){
            dist[i] = INF;
        }
        q.add(new Node(start, 0));
        // start 부터 start 까지의 거리는 0
        dist[start] = 0;
        while (!q.isEmpty()){
            Node now = q.poll();
            int nowE = now.end;
            int nowW = now.weight;
            // 현재 노드까지의 거리가 기록된 거리보다 길면 해당 경로는 버림
            if(dist[nowE]<nowW){
                continue;
            }
            // 현재 노드에 연결된 다른 노드를 탐색
            for(Node node:graph[nowE]){
                int nextE = node.end;
                int nextW = node.weight;
                int cost = nowW + nextW;
                if(cost<dist[nextE]){
                    dist[nextE] = cost;
                    q.add(new Node(nextE, cost));
                }
            }
        }
        return dist[end];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new List[N+1];
        check = new boolean[N + 1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i =0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 양방향 저장
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int resultA = 0; //v1->v2일때 최단거리
        int resultB = 0; // v2->v1 일때 최단거리

        resultA += dijkstra(1, v1);
        resultA += dijkstra(v1, v2);
        resultA += dijkstra(v2, N);

        resultB += dijkstra(1, v2);
        resultB += dijkstra(v2, v1);
        resultB += dijkstra(v1, N);
        // 그러한 경로가 없는 경우
        int result = 0;
        if(resultA>=INF&&resultB>=INF){
            result = -1;
        }
        else{
            result = Math.min(resultA, resultB);
        }
        System.out.println(result);
    }
}