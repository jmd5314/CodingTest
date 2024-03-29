import java.io.*;
import java.util.*;

public class Main {
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        Queue<Long> q = new LinkedList<>();
        q.add(B);
        while (!q.isEmpty()){
            long num = q.poll();
            String str = Long.toString(num);
            if(num==A){
                System.out.println(count);
                System.exit(0);
            }
            // A 보다 작아지면 A에 도달할 수 없는 것이므로 count 값을 -1로 초기화 하고 반환
            else if(num<A){
                System.out.println(-1);
                System.exit(0);
            }
            if(num%2==0){
                num/=2;
                q.add(num);
                count++;
            }
            // 만약 끝자리가 1인 홀수 인 경우
            else if(str.charAt(str.length()-1)=='1'){
                num = Long.parseLong(str.substring(0, str.length() - 1));
                q.add(num);
                count++;
            }
            // 둘 다 해당 안되면 만들 수 없음
            else{
                System.out.println(-1);
                System.exit(0);
            }
        }
    }
}
