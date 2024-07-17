import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer>[]graph = new List[n + 1];
            for(int i =1;i<=n;i++){
                graph[i] = new ArrayList<>();
            }
            // 작년 랭크
            int[] prev = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                prev[i] = Integer.parseInt(st.nextToken());
            }
            int[] count = new int[n + 1];
            for(int i =1;i<=n;i++){
                for(int j=i+1;j<=n;j++){
                    graph[prev[i]].add(prev[j]);
                    count[prev[j]]++;
                }
            }
            int m = Integer.parseInt(br.readLine());
            for(int i =0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                Integer a = Integer.parseInt(st.nextToken());
                Integer b = Integer.parseInt(st.nextToken());
                if (graph[a].contains(b)) {
                    graph[a].remove(b);
                    graph[b].add(a);
                    count[a]++;
                    count[b]--;
                }
                else{
                    graph[b].remove(a);
                    graph[a].add(b);
                    count[b]++;
                    count[a]--;
                }
            }
            Queue<Integer> q = new LinkedList<>();
            for(int i =1;i<=n;i++){
                if(count[i]==0)
                    q.add(i);
            }
            List<Integer> ans = new ArrayList<>();
            while (!q.isEmpty()) {
                // 큐에 들어간 순서가 2개 이상이면 순위를 정할 수 없음
                if (q.size() > 1) {
                    sb.append("?").append("\n");
                    break;
                }
                int now = q.poll();
                ans.add(now);
                for(int i =0;i<graph[now].size();i++){
                    count[graph[now].get(i)]--;
                    if(count[graph[now].get(i)]==0)
                        q.add(graph[now].get(i));
                }

            }
            if(ans.size()!=n)
                sb.append("IMPOSSIBLE").append("\n");
            else{
                for(int i:ans){
                    sb.append(i).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}