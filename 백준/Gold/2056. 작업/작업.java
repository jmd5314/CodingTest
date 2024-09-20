import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int e;
        int v;

        public Node(int e, int v) {
            this.e = e;
            this.v = v;
        }
    }

    static int N;
    static Node[] nodes;
    static List<Integer>[] list;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];
        list = new List[N + 1];
        count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(i, v);
            int k = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= k; j++) {
                int a = Integer.parseInt(st.nextToken());
                list[a].add(i);
                count[i]++;
            }
        }
        // 시간이 더 빨리 걸리는 수 부터 q에서 빼야함
        PriorityQueue<Node> q = new PriorityQueue<>(((o1, o2) -> {
            return o1.v - o2.v;
        }));
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
                q.add(nodes[i]);
            }
        }
        while (!q.isEmpty()) {
            Node now = q.poll();
            int e = now.e;
            int v = now.v;
            nodes[e] = now;
            for (int i : list[e]) {
                count[i]--;
                if (count[i] == 0) {
                    q.add(new Node(i, v + nodes[i].v));
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, nodes[i].v);
        }
        System.out.println(result);
    }
}