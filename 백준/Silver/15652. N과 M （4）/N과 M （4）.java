import java.io.*;
import java.util.*;
public class Main{
    public static int arr[] ;
    public static int N,M;
    public static StringBuilder sb = new StringBuilder();
    public static void dfs(int at,int d){
        //재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
        if(d==M){
            for(int val:arr){
                sb.append(val+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=at;i<=N;i++){
            arr[d] = i;
            dfs(i,d+1); // i를 넘겨줌으로써 부모 노드와 같거나 높은 자식 노드만 추가 할 수 있도록 함
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(1,0);
        System.out.println(sb);
    }
}