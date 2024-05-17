import java.util.*;
import java.io.*;
public class Main {
    public static int isPal(String S){
        // reverse 한 문자열과 동일하면 회문
        if (S.equals(new StringBuilder(S).reverse().toString())) {
            return 0;
        }
        // 회문을 만족하지 않는 경우
        else {
            int start = 0;
            int end = S.length() - 1;
            while (start < end) {
                // 만약 서로 문자가 맞지 않는다면
                if (S.charAt(start) != S.charAt(end)) {
                    // 왼쪽을 지우거나 오른쪽을 지우고 둘 중 하나라도 회문이 된다면 유사회문임
                    StringBuilder deleteLeft = new StringBuilder(S).deleteCharAt(start);
                    StringBuilder deleteRight = new StringBuilder(S).deleteCharAt(end);

                    if (deleteLeft.toString().equals(deleteLeft.reverse().toString()) ||
                            deleteRight.toString().equals(deleteRight.reverse().toString())) {
                        return 1;
                    }
                    break;
                }
                start++;
                end--;
            }
            // 유사회문의 조건을 만족하지 않은 경우 일반 문자열
            return 2;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            String S = br.readLine();
            result.append(isPal(S)).append("\n");
        }
        System.out.println(result);
    }
}