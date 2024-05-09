import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int temp = 0;
        while(true){
            // 5의 배수면 5원자리 동전 수만큼 count 하면 됨
            if(N%5 == 0){
                count += N/5;
                System.out.println(count);
                break;
            }
            // 5의 배수가 아니라면 2원 짜리 동전을 하나씩 빼면서 count 함
            else{
                N -= 2;
                count++;
            }
            // 나머지가 1인 경우는 2원 짜리 동전을 빼면 음수가 되므로 -1 출력
            if(N < 0){
                System.out.println(-1);
                break;
            }
        }
    }
}
