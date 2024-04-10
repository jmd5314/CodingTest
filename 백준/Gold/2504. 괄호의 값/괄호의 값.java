import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Q = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int value = 1;
        for(int i =0;i<Q.length();i++){
            if(Q.charAt(i)=='('){
                stack.push('(');
                value*=2;
            }
            else if(Q.charAt(i)=='['){
                stack.push('[');
                value*=3;
            }
            else if(Q.charAt(i)==')'){
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }
                else if(Q.charAt(i-1)=='('){
                    result +=value;
                }
                stack.pop();
                value /=2;
            }
            else{
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (Q.charAt(i - 1) == '[') {
                    result+=value;
                }
                stack.pop();
                value/=3;
            }
        }
        if(!stack.isEmpty())
            System.out.println(0);
        else
            System.out.println(result);
    }
}