import java.io.*;
import java.util.*;
public class Main {
    private static long factorial(long N){
        if(N==1||N==0)
            return 1;
        return N * factorial(N - 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        System.out.println(factorial(N));
    }
}