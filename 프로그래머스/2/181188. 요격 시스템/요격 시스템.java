import java.util.*;
class Solution {
    public static class Node {
        int s;
        int e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public int solution(int[][] targets) {
        Node[] list = new Node[targets.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = new Node(targets[i][0], targets[i][1]);
        }
        // 끝 범위 빠른 순 정렬
        Arrays.sort(list, ((o1, o2) -> {
            return o1.e - o2.e;
        }));

        // 끝 범위 느린 순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> {
            return o2 - o1;
        }));
        pq.add(list[0].e);
        for (int i = 1; i < list.length; i++) {
            if(list[i].s>=pq.peek()){
                pq.add(list[i].e);
            }
        }
        return pq.size();
    }
}
