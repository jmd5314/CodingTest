import java.util.*;
public class Main {
    private static boolean isNum(String s){
        if(!Character.isDigit(s.charAt(0)))
            return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Integer,String> map2 = new HashMap<>();
        for(int i =1;i<=N;i++){
            String name = sc.next();
            map1.put(name, i);
            map2.put(i,name);
        }
        for(int i =0;i<M;i++){
            String question = sc.next();
            if(!isNum(question))
                sb.append(map1.get(question)).append("\n");
            else
                sb.append(map2.get(Integer.parseInt(question))).append("\n");
        }
        System.out.println(sb);
    }
}