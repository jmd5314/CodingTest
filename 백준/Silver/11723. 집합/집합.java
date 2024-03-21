import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            String q = st.nextToken();
            if(q.equals("add")){
                int x = Integer.parseInt(st.nextToken());
                if(!list.contains(x))
                    list.add(x);
            }
            else if(q.equals("remove")){
                int x = Integer.parseInt(st.nextToken());
                if(list.contains(x))
                    list.remove(Integer.valueOf(x));
            }
            else if(q.equals("check")){
                int x = Integer.parseInt(st.nextToken());
                if(list.contains(x))
                    sb.append(1 + "\n");
                else
                    sb.append(0 + "\n");
            }
            else if(q.equals("toggle")){
                int x = Integer.parseInt(st.nextToken());
                if(list.contains(x))
                    list.remove(Integer.valueOf(x));
                else
                    list.add(x);
            }
            else if(q.equals("all")){
                list.clear();
                for(int j =1;j<=20;j++){
                    list.add(j);
                }
            }
            else{
                list.clear();
            }
        }
        System.out.println(sb);
    }
}