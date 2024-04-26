import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        int last = -1;
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String q = st.nextToken();
            if(q.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
                last = num;
            }
            else if(q.equals("pop")){
                if(queue.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(queue.poll()).append("\n");
            }
            else if(q.equals("size")){
                sb.append(queue.size()).append("\n");
            }
            else if(q.equals("empty")){
                if(queue.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
            else if(q.equals("front")){
                if(queue.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(queue.peek()).append("\n");
            }
            else{
                if(queue.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(last).append("\n");
            }
        }
        System.out.println(sb);
    }
}