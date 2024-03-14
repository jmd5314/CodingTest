import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) ->{
            int num1 = Math.abs(o1);
            int num2 = Math.abs(o2);
            if(num1 == num2){
                return o1>o2?1:-1;
            }
            return num1 - num2;
        } );
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            //x가 0일때 비어있으면 0을 출력, 비어있지 않으면 맨 앞에 위치한 값을 제거, 출력
            if(x == 0) {
                if(pq.isEmpty()) sb.append(0).append("\n");
                else {
                    sb.append(pq.poll()).append("\n");
                }
            }else {
                pq.offer(x);
            }
        }
        System.out.println(sb);
    }
}