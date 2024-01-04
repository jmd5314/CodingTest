import java.io.*;
import java.util.*;
public class Main{
    public static int count = 0;
    public static int recursion(String s, int l, int r){
        if(l >= r) {
            count++;
            return 1;}
        else if(s.charAt(l) != s.charAt(r)){
            count++;
            return 0;
        }
        else {
            count++;
            return recursion(s, l+1, r-1);
        }
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i =0;i<T;i++){
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            sb.append(isPalindrome(str)).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}