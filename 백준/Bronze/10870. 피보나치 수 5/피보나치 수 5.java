import java.io.*;
import java.util.*;
public class Main {
    private static int fibonacci(int N){
        if(N==0)
            return 0;
        if(N==1)
            return 1;
        return fibonacci(N-2)+fibonacci(N-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(N));
    }
}