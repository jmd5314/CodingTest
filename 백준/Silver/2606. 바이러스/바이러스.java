import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean check[];
    public static void dfs(int start){
        check[start] = true;
        for(int i=0;i<graph.get(start).size();i++){
            int next = graph.get(start).get(i);
            if(!check[next]){
                check[next] = true;
                dfs(next);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        check = new boolean[N + 1];
        for(int i =0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        // 오름차순 정렬
        for(int i =0;i<=N;i++){
            Collections.sort(graph.get(i));
        }
        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(1);
        int count =0 ;
        // 방문한적이 있는 컴퓨터 개수 체크
        for(int i =1;i<=N;i++){
            if(check[i])
                count++;
        }
        // 1번 컴퓨터는 count 에서 제외한다
        System.out.println(count-1);
    }
}
