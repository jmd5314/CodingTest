import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N<3){
            N+=2;
        }
        String result = (N - 3) % 2 == 1 ? "CY" : "SK";
        System.out.println(result);
    }
}