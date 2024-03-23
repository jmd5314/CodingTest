import java.io.*;
import java.util.*;

public class Main {
    //메모리를 아끼기 위해 이중 리스트로 그래프를 초기화
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    //방문한 정점들 기록할 배열
    static int [] check;
    // 방문 순서
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        check = new int[N+1];
        // 그래프의 index를 정점 개수만큼 만들어줌
        for(int i =0;i<N+1;i++){
            graph.add(new ArrayList<>());
        }
        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 양방향 그래프이기 때문에 둘다 추가
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        // 각 정점 내림차순으로 정렬
        for(int i =1;i<=N;i++){
            Collections.sort(graph.get(i),Collections.reverseOrder());
        }
        // 시작 정점도 순서에 포함이므로 초기값 1
        count = 1;
        bfs(R);
        for(int i=1;i<check.length;i++){
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int vertex) {
        Queue<Integer> q = new LinkedList<>();
        //시작 정점 큐에 저장
        q.offer(vertex);
        // 시작 정점 순서 저장 후 count 증가
        check[vertex] = count++;
        while (!q.isEmpty()){
            int a = q.poll();
            // 현재 방문한 정점이 갈 수 있는 정점 리스트를 순회
            for(int i=0;i<graph.get(a).size();i++){
                int nextVertex = graph.get(a).get(i);
                if(check[nextVertex]==0){
                    q.offer(nextVertex);
                    check[nextVertex] = count++;
                }
            }
        }
    }
}