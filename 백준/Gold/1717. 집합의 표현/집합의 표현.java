import java.util.*;
import java.io.*;
public class Main {
    static int [] p;
    // x의 부모를 찾는 연산
    public static int find(int x){
        if(x==p[x])
            return x;
        // 부모의 부모가 있을 수 있기때문에 재귀함수로 return 하면서 저장해줌
        return p[x] = find(p[x]);
    }
    // y의 부모를 x의 부모로 치환하는 연산
    public static void union(int x,int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            if(x<y){
                p[y] = x;
            }
            //x>y인 경우 반대
            else{
                p[x] = y;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        p = new int[n + 1];
        // 부모 자기자신으로 초기화
        for(int i =0;i<=n;i++){
            p[i] = i;
        }
        for(int i =0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(q==0){
                union(a, b);
            }
            else{
                // 두 수의 부모가 같으면 같은 집합에 포함된 것
                if(find(a)==find(b)){
                    sb.append("YES").append("\n");
                }
                else{
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}