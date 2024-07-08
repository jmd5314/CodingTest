import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static int N, M;
    static int[] count;
    static StringBuilder sb = new StringBuilder();
    public static void topologicalSort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i =1;i<=N;i++){
            // 자신 앞에 수가 없는 수들 큐에 추가
            if(count[i]==0)
                q.add(i);
        }
        for(int i =1;i<=N;i++){
            if(!q.isEmpty()){
                int num = q.poll();
                sb.append(num).append(" ");
                for(int j =0;j<list[num].size();j++){
                    // 현재 값을 앞에 둔 수들 카운트 감소
                    count[list[num].get(j)]--;
                    if(count[list[num].get(j)]==0){
                        // 더이상 앞에 수가 없는 수 큐에 추가
                        q.add(list[num].get(j));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N + 1];
        count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
            // B 앞의 수 갯수 카운트 증가
            count[B]++;
        }
        topologicalSort();
        System.out.println(sb);
    }
}