import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        StringBuilder sb = new StringBuilder();
        Integer[] num = new Integer[N.length()];
        for(int i =0;i<num.length;i++){
            num[i] = N.charAt(i) - '0';
        }
        Arrays.sort(num, Collections.reverseOrder());
        int result = 0;
        for(int i =0;i<num.length;i++){
            result += num[i];
        }
        // 30의 배수이려면 마지막 끝자리가 반드시 0이어야 하고 각 자리수의 합이 3의 배수여야 함
        if (result % 3 != 0 || num[num.length - 1] != 0) {
            sb.append(-1);
        }
        else{
            for (int i = 0; i < num.length; i++) {
                sb.append(num[i]);
            }
        }
        System.out.println(sb);

    }
}