import java.io.*;
import java.util.*;
public class Main {
    static int [] arr;
    static boolean [] check;
    static boolean [] done;
    static int n;
    static int count;
    /* 사이클이 생성되서 방문 했던 곳을 한번 더 방문 한 경우 done 체크 후 count 증가
     * 최대 깊이까지 dfs 를 한 후에는 이미 검사가 끝난 것이기 때문에 done 체크 후 방문 체크는 초기화
     */
    public static void dfs(int s) {
        // 이전에 이미 검사한 것이므로 더이상 검사할 필요 없음
        if (done[s])
            return;
        // 이전에 방문을 했었다는 뜻이므로 사이클이 완성 됐다는 뜻
        if (check[s]) {
            done[s] = true;
            count++;
        }
        check[s] = true;
        dfs(arr[s]);
        done[s] = true;
        check[s] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            count = 0;
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            check = new boolean[n + 1];
            done = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            for(int i =1;i<=n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i =1;i<=n;i++){
                if(done[i])
                    continue;
                dfs(i);
            }
            sb.append(n-count).append("\n");
        }
        System.out.println(sb);
    }
}