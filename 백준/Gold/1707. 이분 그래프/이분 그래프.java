import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // 색깔을 1,-1 로 구별
    static int colors[];
    static int V,E;
    static final int Black = 1;
    public static boolean bfs(int vertex,int color){
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        colors[vertex] = color;
        while (!q.isEmpty()){
            int now = q.poll();
            for(int i =0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i);
                if(colors[next]==0){
                    // 다음 컬러는 현재 컬러의 반대이기 때문에 -1을 곱해줌
                    colors[next] = colors[now] * -1;
                    q.add(next);
                }
                else{
                    // 이미 컬러가 칠해져 있는데 현재 컬러와 같은 경우 이분 그래프가 될 수 없음
                    if(colors[now]==colors[next])
                        return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        while (K-->0){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            colors = new int[V + 1];
            for(int i =0;i<=V;i++){
                graph.add(new ArrayList<>());
            }
            for(int i =0;i<E;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            boolean check = false;
            for(int i=1;i<=V;i++){
                if(colors[i]==0){
                    // 첫 시작은 무조건 검정으로 칠해줌
                    check = bfs(i, Black);
                }
                // check가 false면 break
                if(!check)
                    break;
            }
            if(!check)
                System.out.println("NO");
            else
                System.out.println("YES");
            graph.clear();
        }
    }
}