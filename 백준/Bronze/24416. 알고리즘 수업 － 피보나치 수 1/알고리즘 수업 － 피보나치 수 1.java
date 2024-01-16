import java.io.*;
import java.util.*;
public class Main{
    public static int count1 = 0;
    public static int count2 = 0;
    public static int count_rec(int n){
        if(n==1||n==2) {
            count1++;
            return 1;
        }
        else {
            return count_rec(n-1)+count_rec(n-2);
        }
    }
    public static int count_din(int n){
        int f[] = new int[n];
        f[0] = 1;
        f[1] = 1;
        for(int i=2;i<n;i++){
            f[i] = f[i-1]+f[i-2];
            count2++;
        }
        return f[n-1];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        count_rec(N);
        count_din(N);
        System.out.println(count1+" "+count2);
    }
}