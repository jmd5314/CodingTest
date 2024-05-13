import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = 0;
        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B, (a, b) -> b.compareTo(a));
        for (int i =0;i<N;i++){
            S += A[i] * B[i];
        }
        System.out.println(S);
    }
}