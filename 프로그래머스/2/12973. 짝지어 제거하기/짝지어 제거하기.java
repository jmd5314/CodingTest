import java.util.*;
class Solution
{
    public int solution(String s)
    {
        char ch[] = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<ch.length;i++){
            if(stack.isEmpty())
                stack.push(ch[i]);
            else{
                if(stack.peek()==ch[i])
                    stack.pop();
                else
                    stack.push(ch[i]);
            }
        }
        return stack.isEmpty()?1:0;
    }
}