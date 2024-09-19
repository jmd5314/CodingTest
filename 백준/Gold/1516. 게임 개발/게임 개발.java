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
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        nodes = new Node[N + 1];
        list = new List[N + 1];
        count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            String[] str = br.readLine().split(" ");
            nodes[i] = new Node(i, Integer.parseInt(str[0]));
            for (int j = 1; j < str.length; j++) {
                int num = Integer.parseInt(str[j]);
                if (num == -1)
                    break;
                list[num].add(i);
                count[i]++;
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> {
            return o1.v - o2.v;
        }));
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0)
                pq.add(nodes[i]);
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            nodes[now.e] = now;
            for (int i : list[now.e]) {
                count[i]--;
                if (count[i] == 0) {
                    pq.add(new Node(i, nodes[i].v + now.v));
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            sb.append(nodes[i].v).append("\n");
        }
        System.out.println(sb);
    }
}