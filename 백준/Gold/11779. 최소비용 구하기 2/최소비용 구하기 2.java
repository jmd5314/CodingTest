import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static List<Node>[] graph;
    static int [] dist;
    // 이전 도시
    static int[] prev;
    public static class Node{
        int e;
        int w;
        public Node(int e,int w){
            this.e = e;
            this.w = w;
        }
    }
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> {
            return o1.w - o2.w;
        }));
        pq.add(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()){
            Node now = pq.poll();
            int nowE = now.e;
            if (dist[nowE] < now.w)
                continue;
            for(int i =0;i<graph[nowE].size();i++){
                    Node next = graph[nowE].get(i);
                    // 최단거리 업데이트
                    if (dist[next.e] > dist[nowE] + next.w) {
                        dist[next.e] = dist[nowE] + next.w;
                        // 이전 마을 기록
                        prev[next.e] = nowE;
                        pq.add(new Node(next.e, dist[next.e]));
                    }

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        prev = new int[n + 1];
        graph = new List[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i =1;i<=n;i++){
            graph[i] = new ArrayList<>();

        }
        for(int i =0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);
        System.out.println(dist[end]);
        //경로 역추적
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        int index = end;
        // 이전 도시가 있을때까지 역 추적 해서 Stack 에 추가
        while (prev[index]!=0){
            stack.push(prev[index]);
            index = prev[index];
        }
        System.out.println(stack.size());
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}