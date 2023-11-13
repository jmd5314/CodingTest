import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        String str = br.readLine();
        int sum = 0;
        int K = Integer.parseInt(str);
        for(int i = 0;i<K;i++){
            String s = br.readLine();
            int N = Integer.parseInt(s);
            if(N==0){
                stack.pop();
            }
            else
                stack.push(N);
        }
        for(int i:stack)
            sum+=i;
        System.out.println(sum);
    }
}