import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] list;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            count[b]++;
        }
        // 풀 수 있는 문제 중 가장 쉬운 문제부터 풀어야 하기 때문에 오름차순 정렬이 되는 우선순위 큐를 사용한다
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
                pq.add(i);
            }
        }
        while (!pq.isEmpty()) {
            int now = pq.poll();
            sb.append(now).append(" ");
            for (int i : list[now]) {
                count[i]--;
                if (count[i] == 0) {
                    pq.add(i);
                }
            }
        }
        System.out.println(sb);

    }
}