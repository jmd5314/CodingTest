import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        String str = br.readLine();
        int N = Integer.parseInt(str);
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("1")){
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("2")){
                if(!stack.empty()){
                    sb.append(stack.pop()).append("\n");
                }
                else
                    sb.append(-1).append("\n");
            }
            else if(command.equals("3")){
                sb.append(stack.size()).append("\n");
            }
            else if(command.equals("4")){
                if(stack.empty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
            else {
                if(!stack.empty()){
                    sb.append(stack.peek()).append("\n");
                }
                else
                    sb.append(-1).append("\n");
            }
        }
        br.close();
        System.out.println(sb);
    }
}