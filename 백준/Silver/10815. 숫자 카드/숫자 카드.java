import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<N;i++){
            map.put(sc.nextInt(),0);
        }
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<M;i++){
            if(map.get(sc.nextInt())!=null){
                sb.append(1).append(" ");
            }
            else
                sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}