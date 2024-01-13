
import java.io.*;
import java.util.*;
public class Main{
    public static String cantor(String s){
        StringBuilder sb = new StringBuilder();
        int l = s.length();
        if(l==1)
            return "-";
        String s1 = s.substring(0,l/3);
        String s2 = s.substring(l/3,l-l/3);
        String s3 = s.substring(l-l/3,l);
        s2 = s2.replace('-', ' ');
        sb.append(cantor(s1)).append(s2).append(cantor(s3));
        return sb.toString();
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine())!=null) {
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(str);
            for (int i = 0; i < (int) Math.pow(3, N); i++) {
                sb.append("-");
            }
            String result = cantor(sb.toString());
            System.out.println(result);
        }
    }
}