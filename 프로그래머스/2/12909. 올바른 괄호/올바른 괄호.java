import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack <Integer> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(!stack.isEmpty()){
                if(s.charAt(i)=='(')
                    stack.push(1);
                else
                    stack.pop();
            }
            else{
                if(s.charAt(i)=='(')
                    stack.push(1);
                else
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}