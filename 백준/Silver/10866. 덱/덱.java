import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        int T = Integer.parseInt(st.nextToken());
        for(int i =0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            String q = st.nextToken();
            if(q.equals("push_back")){
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            }
            else if(q.equals("push_front")){
                int num = Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            }
            else if(q.equals("front")){
                if(!deque.isEmpty())
                    sb.append(deque.peekFirst()).append("\n");
                else
                    sb.append(-1).append("\n");
            }
            else if(q.equals("back")){
                if(!deque.isEmpty())
                    sb.append(deque.peekLast()).append("\n");
                else
                    sb.append(-1).append("\n");

            }
            else if(q.equals("size")){
                sb.append(deque.size()).append("\n");
            }
            else if(q.equals("empty")){
                if(!deque.isEmpty())
                    sb.append(0).append("\n");
                else
                    sb.append(1).append("\n");

            }
            else if(q.equals("pop_front")){
                if(!deque.isEmpty())
                    sb.append(deque.pollFirst()).append("\n");
                else
                    sb.append(-1).append("\n");
            }
            else{
                if(!deque.isEmpty())
                    sb.append(deque.pollLast()).append("\n");
                else
                    sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}