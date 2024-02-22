import java.util.*;
import java.io.*;

public class Main {
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        num = new int[n];
        num[0] = 1;
        if(n>1)
            num[1] = 2;
        for(int i =2;i<n;i++){
            num[i] = (num[i - 1] + num[i - 2])%10007;
        }
        System.out.println(num[n - 1]);
    }
}