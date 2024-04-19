import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static List<Integer>[] list ;
    static boolean [] visited;
    // bfs 를 이용하여 node 와 edge 갯수를 세고 트리가 맞으면 1 아니면 0을 반환 함
    public static int checkTree(int root){
        Queue<Integer> q = new LinkedList<>();
        int node = 0;
        int edge = 0;
        q.add(root);
        while (!q.isEmpty()){
            int now = q.poll();
            if(!visited[now]){
                visited[now] = true;
                node++;
                for(int i =0;i<list[now].size();i++){
                    int next = list[now].get(i);
                    edge++;
                    if(!visited[next])
                        q.add(next);
                }
            }
        }
        // 그래프를 양방향으로 저장해놔서 edge 의 수가 2배로 세졌기 때문에 2를 나눈 값에 +1 을 해서 tree 인지 확인함
        if((edge/2)+1==node)
            return 1;
        else
            return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int index = 1;
        while (true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n==0&&m==0){
                break;
            }
            list = new List[n+1];
            for(int i =1;i<=n;i++){
                list[i] = new ArrayList<>();
            }
            visited = new boolean[n + 1];
            for(int i =0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            int count = 0;
            // 이미 방문한 노드는 이미 갯수를 센 트리에 포함 되어 있기때문에 넘어감
            for(int i =1;i<=n;i++){
                if(!visited[i])
                    count += checkTree(i);
            }
            if(count>1){
                System.out.println("Case " + index + ": A forest of " + count + " trees.");
            }
            else if(count==1){
                System.out.println("Case " + index + ": There is one tree.");
            }
            else{
                System.out.println("Case " + index +": No trees.");
            }
            index++;
        }
    }
}