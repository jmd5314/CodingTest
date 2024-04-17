import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static List<Integer>[] list;
    static boolean [] visited;
    public static void dfs(int start,int depth){
        if(depth==4){
            System.out.println(1);
            System.exit(0);
        }
        visited[start] = true;
        for(int i =0;i<list[start].size();i++){
            int next = list[start].get(i);
            if(!visited[next]){
                dfs(next, depth + 1);
            }
        }
        /*
         dfs 가 끝나면 방문 체크를 풀어줘야 됨 1-3-4 1-2-3-4 인 경우 1 이후 
          3 dfs 를 다 돌리고 나면 2는 3을 방문하기 어려움
         */
        visited[start] = false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N];
        for(int i =0;i<N;i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for(int i =0;i<N;i++){
            visited = new boolean[N];
            dfs(i, 0);
        }
        System.out.println(0);
    }
}