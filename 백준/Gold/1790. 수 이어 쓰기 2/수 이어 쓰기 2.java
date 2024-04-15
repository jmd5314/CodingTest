import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long idx = 1;
        long div = 9;
        long sum = 0;
        while (K>div*idx){
            sum += div;
            K-=div*idx;
            div*=10;
            idx++;
        }
        sum = (sum + 1) + ((K - 1) / idx);
        if(N<sum){
            System.out.println(-1);
        }
        else{
            int c = (int) ((K - 1) % idx);
            System.out.println(String.valueOf(sum).charAt(c));
        }
    }
}