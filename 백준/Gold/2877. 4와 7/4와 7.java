import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        /*
         K+1을 이진수로 바꾸고 맨 앞의 값을 버리면 K번째 일때의 이진수가 나온다
         0이면 4 1이면 7을 더하여 수를 완성해 출력한다
         */
        String s = Integer.toBinaryString(K + 1);
        s = s.substring(1, s.length());
        StringBuilder sb = new StringBuilder(s);
        StringBuilder rs = new StringBuilder();
        while (sb.length()>0){
            if(sb.charAt(0)=='1'){
                rs.append(7);
                sb.deleteCharAt(0);
            }
            else{
                rs.append(4);
                sb.deleteCharAt(0);
            }
        }
        System.out.println(rs);
    }
}