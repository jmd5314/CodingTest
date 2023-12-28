import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("1 ");
        int in = arr[0];

        for(int i=1; i<n; i++){
            deque.add(new int[] {(i+1), arr[i]});
        }

        while(!deque.isEmpty()) {
            if(in >0) {
                for(int i=1; i<in; i++) {
                    deque.addLast(deque.pollFirst());
                }

                int[] nxt = deque.pollFirst();
                in = nxt[1];
                sb.append(nxt[0]+" ");
            }
            else {
                for(int i=1; i<-in; i++	) {
                    deque.addFirst(deque.pollLast());
                }

                int[] nxt = deque.pollLast();
                in = nxt[1];
                sb.append(nxt[0]+" ");
            }
        }
        System.out.println(sb);

    }
}