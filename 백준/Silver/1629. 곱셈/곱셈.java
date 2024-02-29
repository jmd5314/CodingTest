import java.util.*;
import java.io.*;

public class Main {
    public static long pow(long A ,long B,long C){
        if(B==1)
            return A%C;
        long tmp = pow(A, B / 2,C);
        if(B%2==1)
            return (tmp*tmp%C)*A%C;
        return tmp*tmp%C;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(pow(A,B,C));
}
}