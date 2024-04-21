import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static List<Node>[] list;
    static boolean[] visited;
    static int distance;
    public static class Node{
        int idx;
        int cost;
        Node(int idx,int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void dfs(int s,int e,int d){
        if(s==e){
            distance = d;
            return;
        }
        visited[s] = true;
        for(int i =0;i<list[s].size();i++){
            int next = list[s].get(i).idx;
            int cost = list[s].get(i).cost;
            if(!visited[next]){
                dfs(next, e, d + cost);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N + 1];
        for(int i =1;i<=N;i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            visited = new boolean[N + 1];
            dfs(s, e, 0);
            sb.append(distance).append("\n");
        }
        System.out.println(sb);
    }
}