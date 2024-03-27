import java.io.*;
import java.util.*;

public class Main {
    static boolean check[];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void dfs(int vertex){
        check[vertex] = true;
        for(int i =0;i<graph.get(vertex).size();i++){
            int nextVertex = graph.get(vertex).get(i);
            if(!check[nextVertex]){
                dfs(nextVertex);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        check = new boolean[N+1];
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }
        for(int i = 1;i<=N;i++){
            if(!check[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
}
