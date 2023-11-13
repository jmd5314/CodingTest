import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main {
    private static boolean isVPS(String str){
        Stack<String> stack = new Stack<>();
        String st[] = str.split("");
        for(String s:st){
            if(s.equals("("))
                stack.push(s);
            else {
                if(stack.empty())
                    return false;
                stack.pop();
            }
        }
        if(stack.empty())
            return true;
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i =0;i<T;i++){
            if(isVPS(br.readLine()))
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
    }
        System.out.println(sb);
    }
}