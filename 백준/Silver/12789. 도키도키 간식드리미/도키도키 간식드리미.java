import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int index = 1;
        int N = sc.nextInt();
        int num[] = new int[N];
        for(int i =0;i<N;i++){
            num[i] = sc.nextInt();
        }
        for(int i =0;i<num.length;i++){
            if(num[i]==index){
                index++;
            }
            else{
                if(!stack.empty()&&stack.peek()==index){
                    stack.pop();
                    i--;
                    index++;
                }
                else{
                    stack.push(num[i]);
                }
            }
        }
        boolean result = true;
        for(int i =0;i<stack.size();i++){
            if(stack.peek()==index){
                stack.pop();
                index++;
            }
            else{
                result = false;
                break;
            }
        }
        if(result)
            System.out.println("Nice");
        else
            System.out.println("Sad");
    }
}