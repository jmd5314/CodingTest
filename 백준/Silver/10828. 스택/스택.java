import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(st.nextToken());
        while (N-->0){
            st = new StringTokenizer(br.readLine());
            String q = st.nextToken();
            if (q.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else if (q.equals("pop")) {
                if(stack.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(stack.pop()).append("\n");
            }
            else if (q.equals("size")) {
                sb.append(stack.size()).append("\n");
            }
            else if(q.equals("empty")){
                if(stack.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
            else{
                if(stack.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(stack.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }
}