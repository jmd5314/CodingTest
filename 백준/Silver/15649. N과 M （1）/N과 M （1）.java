import java.io.*;
import java.util.StringTokenizer;
public class Main{
    public static boolean[] visit;
    public static int arr[] ;
    public static StringBuilder sb = new StringBuilder();
    public static void dfs(int N,int M,int d){
        //재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
        if(d==M){
            for(int val:arr){
                sb.append(val+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i =0;i<N;i++){
            // 만약 해당 노드(값)을 방문하지 않았다면
            if(!visit[i]){
                visit[i] = true; //방문 상태로 변경
                arr[d] = i+1; //해당 깊이를 index 로 하여 i+1값 저장
                dfs(N,M,d+1); //다음 자식 노드 방문을 위해 d 1증가시키면서 재귀 호출

                //자식 노드 방문이 끝나고 돌아오면 방문 노드를 방문하지 않은 상태로 변경 -> 매우 중요!!!
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        arr = new int[M];
        dfs(N,M,0);
        System.out.println(sb);
    }
}