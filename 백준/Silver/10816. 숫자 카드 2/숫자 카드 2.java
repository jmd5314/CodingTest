import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        for(int i =0;i<N;i++){
            int n = sc.nextInt();
            if(map.containsKey(n)){
                int value = map.get(n)+1;
                map.put(n, value);
            }
            else
                map.put(n, 1);
        }
        int M = sc.nextInt();
        for(int i =0;i<M;i++){
            int m = sc.nextInt();
            if(!map.containsKey(m))
                sb.append(0).append(" ");
            else
                sb.append(map.get(m)).append(" ");
        }
        System.out.println(sb);
    }
}