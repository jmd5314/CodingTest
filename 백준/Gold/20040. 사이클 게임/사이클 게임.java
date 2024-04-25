import java.util.*;
import java.io.*;
public class Main {
    static int [] p;
    static int [] l;
    public static int find(int x){
        if(p[x]==x)
            return x;
        return p[x] = find(p[x]);
    }
    public static void union(int x,int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            if(x<y){
                p[y] = x;
            }
            else{
                p[x] = y;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        p = new int[n];
        l = new int[n];
        for(int i =0;i<n;i++){
            p[i] = i;
            l[i] = 1;
        }
        for(int i =1;i<=m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 이미 서로 같은 집합에 포함되어 있는데 선분을 그을 경우 사이클이 생김
            if(find(a)==find(b)){
                System.out.println(i);
                System.exit(0);
            }
            // 사이클이 발생하지 않았으면 서로 union 해줌
            else
                union(a, b);

        }
        System.out.println(0);
    }
}
