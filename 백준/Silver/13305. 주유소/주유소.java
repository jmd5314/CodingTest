import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] rl = new long[N - 1];
        long[] oil = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N-1;i++){
            rl[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            oil[i] = Long.parseLong(st.nextToken());
        }
        long min = oil[0];
        long total = 0;
        for(int i =1;i<N;i++){
            if(min>oil[i]){
                total += min * rl[i - 1];
                min = oil[i];
            }
            else{
                total += min * rl[i - 1];
            }
        }
        System.out.println(total);
    }
}