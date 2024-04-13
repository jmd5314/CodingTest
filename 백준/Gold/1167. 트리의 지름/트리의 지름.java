import java.util.*;
import java.io.*;
public class Main {
    public static class Node{
        int e;
        int cost;
        Node(int e,int cost){
            this.e = e;
            this.cost = cost;
        }
    }
    static int N;
    static ArrayList<Node> list[];
    static boolean [] visited;
    static int max = 0;
    static int node;
    public static void dfs(int x,int len){
        if(len>max){
            max = len;
            node = x;
        }
        visited[x] = true;
        for(int i =0;i<list[x].size();i++){
            Node n = list[x].get(i);
            if(!visited[n.e]){
                dfs(n.e,len+n.cost);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for(int i =0;i<=N;i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while (true){
                int e = Integer.parseInt(st.nextToken());
                if(e==-1)
                    break;
                int cost = Integer.parseInt(st.nextToken());
                list[s].add(new Node(e, cost));
            }
        }
        visited = new boolean[N + 1];
        // 임의의 노드 1에서 부터 가장 먼 노드를 dfs로 찾아 node에 저장한다
        dfs(1, 0);
        visited = new boolean[N + 1];
        // 해당 노드에서 가장 먼 노드 사이의 거리가 트리의 지름이 된다. 임의의 점에서 가장 먼 노드는 트리의 지름의 두 노드 중 한 노드가 된다.
        dfs(node, 0);
        System.out.println(max);
    }
}