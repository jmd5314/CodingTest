import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pos = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        PriorityQueue<Integer> neg = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        int result = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > 0) {
                pos.add(num);
            }
            if (num < 0) {
                neg.add(Math.abs(num));
            }
        }
        // 가장 먼거리를 저장 해놓는다
        int max = 0;
        if (pos.isEmpty()) {
            max = neg.peek();
        } else if (neg.isEmpty()) {
            max = pos.peek();
        } else {
            max = Math.max(pos.peek(), neg.peek());
        }
        while (!pos.isEmpty()) {
            result += 2 * pos.peek();
            for (int i = 0; i < M; i++) {
                pos.poll();
                if (pos.isEmpty())
                    break;
            }
        }
        while (!neg.isEmpty()) {
            result += 2 * neg.peek();
            for (int i = 0; i < M; i++) {
                neg.poll();
                if (neg.isEmpty())
                    break;
            }
        }
        // 가장 먼 거리는 돌아오지 않아도 되므로 뺀다
        result -= max;
        System.out.println(result);
    }
}