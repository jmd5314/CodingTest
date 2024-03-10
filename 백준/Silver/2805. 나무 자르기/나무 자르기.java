import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];

        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

            // 나무들 중 최댓값을 저장
             
            if(max < tree[i]) {
                max = tree[i];
            }
        }

        // 이분 탐색 (upper bound)
        while(min < max) {

            int mid = (min + max) / 2;
            long sum = 0;
            for(int treeHeight : tree) {
                
               // 자르는 위치가 주어진 나무의 높이보다 클 수 있기 때문에 0 이하인 경우(=음수)에는 합산을 하지 않고 양수만 합산하도록 해야함
                 
                if(treeHeight - mid > 0) {
                    sum += (treeHeight - mid);
                }
            }


            //자른 나무 길의의 합이 M보다 작다는 것은 자르는 위치(높이)가 높다는 의미이므로 높이를 낮춰야 함
             
            if(sum < M) {
                max = mid;
            }
            //반대의 경우 높이를 높여야 함
            else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}