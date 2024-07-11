import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> graph[] = new List[N + 1];
        List<Integer> answer = new ArrayList<>();
        int[] count = new int[N + 1];
        for(int i =1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            for(int j=1;j<t;j++){
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                count[b]++;
                a = b;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =1;i<=N;i++){
            if(count[i]==0)
                q.add(i);
        }
        while (!q.isEmpty()){
            int now = q.poll();
            answer.add(now);
            for(int i =0;i<graph[now].size();i++){
                int next = graph[now].get(i);
                count[next]--;
                if(count[next]==0)
                    q.add(next);
            }
        }
        if(answer.size()!=N){
            sb.append(0);
        }
        else{
            for(int i =0;i<N;i++){
                sb.append(answer.get(i)).append("\n");
            }
        }
        System.out.println(sb);
    }
}