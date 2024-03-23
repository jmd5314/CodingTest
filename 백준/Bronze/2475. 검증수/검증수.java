import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num[] = new int[5];
        int sum = 0;
        for(int i =0;i<5;i++){
            num[i] = Integer.parseInt(st.nextToken());
            sum += (int)Math.pow(num[i],2);
        }
        System.out.println(sum%10);
    }
}
