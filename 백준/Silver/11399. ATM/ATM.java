import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            P[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P);
        int sum = P[0];
        for(int i =1;i<N;i++){
            P[i] += P[i-1];
            sum += P[i];
        }
        System.out.println(sum);
    }
}