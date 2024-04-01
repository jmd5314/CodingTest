import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int end;
        int weight;
        public Node(int end,int weight){
            this.end = end;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int max = 100000; // 최대 위치
        PriorityQueue<Node> q = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
        q.add(new Node(N, 0));
        boolean[] check = new boolean[100001];
        while (!q.isEmpty()){
            Node now = q.poll();
            int nowE = now.end;
            int nowW = now.weight;
            // 우선순위 큐이기때문에 여기서 방문 체크를 해준다
            check[nowE] = true;
            if(nowE == K)
                min = Math.min(min, nowW);
            if(nowE*2<=max&&!check[nowE*2]){
                // 순간 이동은 시간이 0이기 때문에
                q.add(new Node(nowE * 2, nowW));
            }
            if(nowE+1<=max&&!check[nowE+1]){
                q.add(new Node(nowE + 1, nowW + 1));
            }
            if(nowE-1>=0&&!check[nowE-1]){
                q.add(new Node(nowE - 1, nowW + 1));
            }
        }
        System.out.println(min);
    }
}