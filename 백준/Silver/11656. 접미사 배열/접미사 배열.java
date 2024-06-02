import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] str = new String[s.length()];
        for(int i =0;i<str.length;i++){
            str[i] = s.substring(i);
        }
        Arrays.sort(str);
        for(int i =0;i< str.length;i++){
            System.out.println(str[i]);
        }
    }
}