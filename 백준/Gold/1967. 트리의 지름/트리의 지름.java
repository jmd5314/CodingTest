import java.util.*;
import java.io.*;
public class Main {
    static List<Node>[] list;
    static int max = 0;
    static int node;
    static boolean[] visited;
    public static class Node{
        int e;
        int w;
        Node(int e,int w){
            this.e = e;
            this.w = w;
        }
    }
    public static void dfs(int v,int length){
        if(length>max){
            max = length;
            node = v;
        }
        visited[v] = true;
        for(int i =0;i<list[v].size();i++){
            Node next = list[v].get(i);
            if(!visited[next.e]){
                dfs(next.e, length + next.w);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        for(int i =0;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[parent].add(new Node(child, w));
            list[child].add(new Node(parent, w));
        }
        visited = new boolean[n + 1];
        dfs(1, 0);
        visited = new boolean[n + 1];
        dfs(node, 0);
        System.out.println(max);
    }
}