import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] w = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            w[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(w);
        int sum = 0;
        for(int i =0;i<N;i++){
            if (sum + 1 < w[i]) {
                break;
            }
            sum += w[i];
        }
        System.out.println(sum + 1);
    }
}