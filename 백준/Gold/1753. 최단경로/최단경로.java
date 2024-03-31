import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        class Node {
            int end;
            int weight;
            public Node (int end,int weight){
                this.end = end;
                this.weight = weight;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[V + 1]; //방문 체크 배열
        int[] result = new int[V + 1]; //최단 경로 값 배열
        List<Node>[] list = new List[V + 1];
        for(int i=1;i<=V;i++){
            list[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE; // 제일 큰값으로 초기화
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }
        // 다익스트라
        PriorityQueue<Node> q = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
        //시작점 최단 경로 0으로 초기화
        result[K] = 0;
        q.add(new Node(K, 0));
        while (!q.isEmpty()){
            Node now = q.poll();
            if(!check[now.end])
                check[now.end] = true;
            for(int i =0;i<list[now.end].size();i++){
                Node next = list[now.end].get(i);
                // 현재 가중치 + 해당 정점으로 향하는 가중치의 값 < 해당 정점으로의 최단 경로 값이면
                if(!check[next.end]&&now.weight+next.weight<result[next.end]){
                    result[next.end] = now.weight + next.weight;
                    q.add(new Node(next.end, result[next.end]));
                }
            }
        }
        for(int i =1;i<=V;i++){
            if(result[i]==Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(result[i]);
        }
    }
}