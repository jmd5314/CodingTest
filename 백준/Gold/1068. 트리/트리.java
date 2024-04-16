import java.util.*;
import java.io.*;
public class Main {
    public static void bfs(int root){
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int now = q.poll();
            // 만약 노드에 담긴게 없다면, 리프 노드이므로 count 증가
            if(list[now].isEmpty())
                count++;
            for(int i =0;i<list[now].size();i++){
                int next = list[now].get(i);
                q.add(next);
            }
        }
    }
    static List<Integer>[] list;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int root = 0;
        list = new List[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            // -1이라면 root Node
            if(num==-1){
                root = i;
                continue;
            }
            list[num].add(i);
        }
        // 제거할 수는 Integer 타입으로 받기
        Integer R = Integer.parseInt(br.readLine());
        // 만약 루트를 없앤다면, 리프 노드는 0반환
        if(R==root){
            System.out.println(0);
            System.exit(0);
        }
        // 제거할 수가 담긴 부모 노드에서 제거할 수 제거
        for(int i =0;i<N;i++){
            if(list[i].contains(R)){
                list[i].remove(R);
            }
        }
        bfs(root);
        System.out.println(count);
    }
}