import java.util.*;
import java.io.*;
public class Main {
    static int [] p;
    public static int find(int x){
        if(p[x]==x)
            return x;
        return p[x] = find(p[x]);
    }
    public static void union(int x,int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            if(x<y)
                p[y] = x;
            else
                p[x] = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        p = new int[N + 1];
        for(int i =1;i<=N;i++){
            p[i] = i;
        }
        for(int i =1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int q = Integer.parseInt(st.nextToken());
                if(q==0)
                    continue;
                union(i, j);
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        for(int i =0;i<M-1;i++){
            int next = Integer.parseInt(st.nextToken());
            // 갈 수 있는 경로라면 서로 같은 집합에 포함되있을 것이기 때문에 제일 상위의 부모가 같다
            if(find(start)==find(next)){
                start = next;
            }
            else{
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }
}