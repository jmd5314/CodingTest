import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        Stack<Character> stack = new Stack<>();
        String S = br.readLine();
        for(int i =0;i<S.length();i++){
            // 열린 꺽새를 만날 경우, stack이 비어있지 않으면 모든 원소를 꺼내고 flag를 true
            if(S.charAt(i)=='<'){
                while (!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                flag = true;
            }
            // 닫힌 꺽새를 만났을 경우 flag를 false '>'까지 sb에 추가
            else if(S.charAt(i)=='>'){
                flag = false;
                sb.append(S.charAt(i));
                continue;
            }
            // flag가 true 라면, '>' 만날때까지 stack에 넣지 않고 그대로 입력
            if(flag){
                sb.append(S.charAt(i));
            }
            //flag가 false 인 경우
            else{
                if(S.charAt(i)==' '){
                    while (!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;
                }
                else{
                    stack.push(S.charAt(i));
                }
            }
            if(i==S.length()-1){
                while (!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
        }
        System.out.println(sb);
    }
}