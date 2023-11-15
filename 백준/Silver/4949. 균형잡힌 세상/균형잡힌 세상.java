import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static String balance(String s){
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
                if(stack.empty()||stack.peek()!='(')
                    return "no";
                else{
                    stack.pop();
                }
            }
            else if(s.charAt(i)==']'){
                if(stack.empty()||stack.peek()!='[')
                    return "no";
                else{
                    stack.pop();
                }
            }
        }
        if(stack.empty())
            return "yes";
        return "no";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        while(true){
            s = br.readLine();
            if(s.equals(".")){
                break;
            }
            sb.append(balance(s)).append("\n");
        }
        System.out.println(sb);
    }
}