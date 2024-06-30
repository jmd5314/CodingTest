import java.util.*;
import java.io.*;
public class Main {
    public static class Node{
        int s;
        int e;
        int w;
        public Node(int s,int e,int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }    
    static int [] parent;
    // 부모찾기 
    public static int find(int x){
        if (x==parent[x])
            return x;
        else {
            return parent[x] = find(parent[x]);
        }
    }
    // 같은 집합으로 합치기
    public static void union(int x,int y){
        int xp = find(x);
        int yp = find(y);
        parent[yp] = xp;
    }
    // 서로 같은 집합에 포함되는지 체크
    public static boolean isContains(int x,int y){
        int xp = find(x);
        int yp = find(y);
        if(xp!=yp)
            return false;
        else
            return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        // 부모를 자기 자신으로 초기화
        for(int i =1;i<=N;i++){
            parent[i] = i;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> {
            return o1.w - o2.w;
        }));
        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.add(new Node(A, B, C));
        }
        long answer = 0;
        int last = 0;
        while (!pq.isEmpty()){
            Node node = pq.poll();
            // 만약 같은 집합에 포함되어 있지 않다면 union 후 길을 answer 에 더해줌
            if(!isContains(node.s,node.e)){
                union(node.s, node.e);
                answer += node.w;
                last = node.w;
            }
        }
        // 다 연결 되었으면 마지막으로 연결한 길은 빼주고 출력한다
        System.out.println(answer - last);
    }
}