import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] product = new int[N];
        for(int i = 0;i<N;i++){
            product[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(product);
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<N;i++){
            if(max<(N-i)*product[i]){
                max = (N-i)*product[i] ; 
            }
        }
        System.out.println(max);
    }
}