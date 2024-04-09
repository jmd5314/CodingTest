import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void fun(Deque<Integer> deque,String p){
        String[] q = p.split("");
        // false 면 D를 앞에 부터 true 면 뒤에부터 하면 됨
        boolean flag = false;
        for(String s:q){
            if(s.equals("R"))
                flag = !flag;
            else{
                if(deque.isEmpty()){
                    sb.append("error").append("\n");
                    return;
                }
                // 뒤에부터 제거
                if(flag){
                    deque.removeLast();
                }
                // 앞에부터 제거
                else{
                    deque.remove();
                }
            }
        }
        sb.append("[");
        int l = deque.size();
        // 뒤에부터 추가
        if(flag){
            for(int i =0;i<l;i++){
                sb.append(deque.removeLast());
                if(i<l-1)
                    sb.append(",");
            }
        }
        // 앞부터 추가
        else{
            for(int i =0;i<l;i++){
                sb.append(deque.remove());
                if(i<l-1)
                    sb.append(",");
            }
        }
        sb.append("]").append("\n");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            Deque<Integer> deque = new ArrayDeque<>();
            String s[] = arr.substring(1, arr.length() - 1).split(",");
            for(int i =0;i<n;i++){
                deque.add(Integer.parseInt(s[i]));
            }
            fun(deque,p);
        }
       System.out.println(sb);
    }
}