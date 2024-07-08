import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static List<Node> [] graph;
    // 오버 플로우 방지를 위해 long 타입 선언
    static long[] dist;
    static final int INF = Integer.MAX_VALUE;
    public static class Node{
        int e;
        int w;
        public Node(int e,int w){
            this.e = e;
            this.w = w;
        }
    }

    public static boolean bellmanFord() {
        // 시작점은 0으로 초기화
        dist[1] = 0;
        boolean check = false;
        // 정정 개수 -1 번만큼 최단거리 초기화 작업
        for(int i =1;i<N;i++){
            check = false;
            for(int j =1;j<=N;j++){
                for(Node node : graph[j]){
                    // 시작점의 최단거리가 무한대라면 다음으로 넘어감
                    if(dist[j]==INF)
                        break;
                    // 만약 시작점까지 최단거리 + 다음 점으로의 가중치가 다음 점의 최단거리보다 적으면 최단거리를 초기화 시켜줌
                    if(dist[node.e]>dist[j]+node.w){
                        dist[node.e] = dist[j] + node.w;
                        check = true;
                    }
                }
            }
            // 만약 더이상 최단거리 초기화가 이루어지지 않으면 더이상 바뀔 것이 없기때문에 반복문을 종료
            if (!check) {
                break;
            }
        }
        /* 정점 개수 -1번 까지 계속 업데이트가 발생했을 경우
         * 정점 개수 번도 업데이트가 발생하면 음수 사이클이 발생한것을 의미
         */
        if(check){
            for(int i =1;i<=N;i++){
                for(Node node: graph[i]){
                    if(dist[i]==INF)
                        break;
                    if(dist[node.e]>dist[i]+node.w){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        dist = new long[N + 1];
        for(int i = 1;i<=N;i++){
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }
        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, C));
        }
        if(bellmanFord()){
            sb.append(-1).append("\n");
        }
        else{
            for(int i =2;i<=N;i++){
                if(dist[i] == INF){
                    sb.append("-1").append("\n");
                }
                else{
                    sb.append(dist[i]).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}