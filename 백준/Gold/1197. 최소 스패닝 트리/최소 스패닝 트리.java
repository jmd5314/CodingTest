import java.util.*;
import java.io.*;
public class Main {
    static int [] parent;
    public static int find(int x){
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static void union (int x,int y){
        int xp = find(x);
        int yp = find(y);
        parent[yp] = xp;
    }
    public static boolean isContains(int x,int y){
        if(find(x)==find(y))
            return true;
        return false;
    }
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];
        for(int i =1;i<=V;i++){
            parent[i] = i;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.w - o2.w));
        for(int i =0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.add(new Node(A, B, C));
        }
        long result = 0;
        while (!pq.isEmpty()){
            Node now = pq.poll();
            if (!isContains(now.s, now.e)) {
                union(now.s, now.e);
                result += now.w;
            }
        }
        System.out.println(result);
    }
}