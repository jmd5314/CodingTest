import java.io.*;
import java.util.*;
public class Main{
    static int arr[][] = new int[31][31];
    private static int BC(int N,int K){
        if(arr[N][K]!=0)
            return arr[N][K];
        if(K==0||K==N)
            return arr[N][K]=1;
        return arr[N][K] = BC(N-1,K-1) + BC(N - 1,K);
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            System.out.println(BC(M, N));
        }
    }
}