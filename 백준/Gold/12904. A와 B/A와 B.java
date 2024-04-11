import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        StringBuilder s = new StringBuilder(S);
        StringBuilder t = new StringBuilder(T);
        while (t.length()>s.length()){
            // 마지막이 A면 A 제거
            if(t.charAt(t.length()-1)=='A'){
                t.deleteCharAt(t.length() - 1);
            }
            // B면 B 제거 후 뒤집기
            else{
                t.deleteCharAt(t.length() - 1).reverse();
            }
        }
        if (s.toString().equals(t.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}