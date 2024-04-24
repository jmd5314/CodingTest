import java.util.*;
import java.io.*;
public class Main {
    static Map<String, Integer> map;
    static int [] p;
    static int [] l;
    public static int find(int x){
        if(x==p[x])
            return x;
        return p[x] = find(p[x]);
    }
    public static int union(int x,int y){
        x = find(x);
        y = find(y);
        // level 은 부모 인덱스에 합쳐서 저장하면 됨
        if(x!=y){
            if(x<y){
                p[y] = x;
                l[x] += l[y];
                return l[x];
            }
            else{
                p[x] = y;
                l[y] += l[x];
                return l[y];
            }
        }
        return l[x];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int F = Integer.parseInt(br.readLine());
            p = new int[2 * F];
            l = new int[2 * F];
            for(int i =0;i<F*2;i++){
                p[i] = i;
                // 초기 층은 각 노드별로 1
                l[i] = 1;
            }
            int index = 0;
            map = new HashMap<>();
            for(int i =0;i<F;i++){
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (!map.containsKey(a))
                    map.put(a, index++);
                if(!map.containsKey(b))
                    map.put(b, index++);
                sb.append(union(map.get(a), map.get(b))).append("\n");
            }
        }
        System.out.println(sb);
    }
}