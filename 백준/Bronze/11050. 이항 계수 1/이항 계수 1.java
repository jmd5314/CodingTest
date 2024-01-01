import java.io.*;
import java.util.*;

public class Main{
    private static int BC(int N,int K){
        if(K==0||K==N)
            return 1;
        return BC(N-1,K-1) + BC(N - 1,K);
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(BC(N,K));
    }
}