import java.io.*;
import java.util.*;
public class Main {
    static int N,K;
    static List<Integer>[] graph;
    // 각 빌딩의 건설 시간
    static int [] building;
    // 해당 빌딩을 짓기 위해 필요한 빌딩 수 
    static int [] count;
    // 해당 빌딩까지 가는 시간 
    static int [] cost;
    public static void topologySort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i =1;i<=N;i++){
            // 자기 자신으로 들어오는게 없는 빌딩은 코스트 값을 자기 자신 건설 비용으로 초기화, 큐에 저장
            if(count[i]==0) {
                cost[i] = building[i];
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int now = q.poll();
            for(int i =0;i<graph[now].size();i++){
                int next = graph[now].get(i);
                // max 를 사용하는 이유는 자기자신으로 오는 길이 2가지 이상인 경우 가장 최대 값을 저장해야되기 때문
                cost[next] = Math.max(cost[now] + building[next], cost[next]);
                count[next]--;
                if(count[next]==0)
                    q.add(next);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        while (T-->0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            building = new int[N + 1];
            count = new int[N + 1];
            cost = new int[N + 1];
            graph = new List[N + 1];
            for(int i =1;i<=N;i++){
                graph[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for(int i =1;i<=N;i++){
                building[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[X].add(Y);
                count[Y]++;
            }
            int W = Integer.parseInt(br.readLine());
            topologySort();
            sb.append(cost[W]).append("\n");
        }
        System.out.println(sb);
    }
}