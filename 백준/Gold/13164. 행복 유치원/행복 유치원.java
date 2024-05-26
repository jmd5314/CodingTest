import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if(N==1){
            System.out.println(0);
            System.exit(0);
        }
        int[] height = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            height[i] = Integer.parseInt(st.nextToken());
        }
        int[] diff = new int[N - 1];
        for(int i =1;i<N;i++){
            diff[i - 1] = height[i] - height[i - 1];
        }
        Arrays.sort(diff);
        int sum = 0;
        for(int i =0;i<N-K;i++){
            sum += diff[i];
        }
        System.out.println(sum);
    }
}