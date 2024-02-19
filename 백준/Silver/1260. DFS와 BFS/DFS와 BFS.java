import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[] visited;

    public static void dfs(int V){
        visited[V] = true;
        System.out.print(V+" ");
        if(V==arr.length){
            return;
        }
        for(int j=1;j<arr.length;j++){
            //연결은 되어있는데, 방문은 안했으면 재귀
            if(arr[V][j]==1&&!visited[j]){
                dfs(j);
            }
        }
    }
    public static void bfs(int V){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(V);
        visited[V] = true;
        System.out.print(V+" ");
        while (!queue.isEmpty()){
            int tmp = queue.poll();
            for(int i =1;i<arr.length;i++){
                if(arr[tmp][i]==1&&!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(i+" ");
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);
    }
}