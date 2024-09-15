import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int e;
        int w;

        public Node(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Node>[] list = new List[N + 1];
        int[] count = new int[N + 1];
        int[] need = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            // 중간 부품 혹은 완제 품에 필요한 부품과 수를 연결
            list[X].add(new Node(Y, K));
            // 필요한 부품에 count 증가
            count[Y]++;
        }
        Queue<Integer> q = new LinkedList<>();
        // 완성품 q에 저장 count = 0 인수
        q.add(N);
        // 완성품은 1개 필요
        need[N] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < list[now].size(); i++) {
                Node next = list[now].get(i);
                /*
                 * 7에 5가 3개 필요하다면 5가 필요한 숫자는 7이 필요한 숫자 * 3
                 */
                need[next.e] += next.w * need[now];
                count[next.e]--;
                if (count[next.e] == 0) {
                    q.add(next.e);
                }
            }
        }
        for(int i = 1;i<=N;i++){
            // 아무런 노드랑 연결되어 있지 않은 수는 기본 부품이므로 출력
            if(list[i].isEmpty()){
                System.out.println(i + " " + need[i]);
            }
        }
    }
}