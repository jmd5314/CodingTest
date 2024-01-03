import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int num[] = new int[A];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<num.length;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        System.out.println(num[0]*num[A-1]);
    }
}