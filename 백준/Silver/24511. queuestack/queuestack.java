import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int type[] = new int[N];
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            type[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            int value = Integer.parseInt(st.nextToken());
            if(type[i]==0)
                deque.add(value);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            deque.addFirst(num);
            sb.append(deque.pollLast()).append(" ");
        }
        System.out.println(sb);
    }
}