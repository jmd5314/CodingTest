import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack <Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        String str = br.readLine();
        String s = br.readLine();
        boolean check ;
        for(int i =0;i<str.length();i++){
            stack.push(str.charAt(i));
            // stack 에 들어가 있는 글자가 비교 문자열 의 길이와 같거나 더 길때 부터 검사
            if(stack.size()>=s.length()){
                check = true;
                for(int j=0;j<s.length();j++){
                    // 현재 스택의 전체 길이 - 검사 문자열의 길이 부터 검사 시작
                    if(stack.get(stack.size()-s.length()+j)!=s.charAt(j)){
                        check = false;
                        break;
                    }
                }
                if(check){
                    // 검사를 다 통과하면 검사 문자열 길이 만큼 pop
                    for(int j=0;j<s.length();j++){
                        stack.pop();
                    }
                }
            }
        }
        for(int i =0;i<stack.size();i++){
            sb.append(stack.get(i));
        }
        if(stack.isEmpty()){
            System.out.println("FRULA");
        }
        else{
            System.out.println(sb);
        }
    }
}