import java.util.*;
import java.io.*;

public class Main {
    static int count;
    public static void count(int n){
        for(int i =1;i<=3;i++){
            if(n-i==0){
                count++;
            }
            else if(n-i<0){
                return;
            }
            else{
                count(n-i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int i =0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            count = 0;
            count(n);
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}