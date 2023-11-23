import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int back = 0;
        StringTokenizer st ;
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                back = num;
                queue.offer(back);
            }
            else if(command.equals("pop")){
                if(queue.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(queue.poll()).append("\n");
            }
            else if(command.equals("size")){
                sb.append(queue.size()).append("\n");
            }
            else if(command.equals("empty")){
                if(queue.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
            else if(command.equals("front")){
                if(!queue.isEmpty())
                    sb.append(queue.peek()).append("\n");
                else
                    sb.append(-1).append("\n");
            }
            else{
                if(!queue.isEmpty())
                    sb.append(back).append("\n");
                else
                    sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}