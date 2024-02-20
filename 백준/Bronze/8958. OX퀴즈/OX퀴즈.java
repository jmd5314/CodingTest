import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int i =0;i<T;i++){
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            Stack<Integer> stack = new Stack<>();
            char[] ch = st.nextToken().toCharArray();
            for(int j=0;j<ch.length;j++){
            if(ch[j]=='O'){
                stack.push(j);
            }
            else{
                stack.clear();
            }
                sum += stack.size();
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}