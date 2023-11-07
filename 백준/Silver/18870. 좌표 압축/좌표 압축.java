import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int points[] = new int[N];
        int copy[] = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            points[i]  = sc.nextInt();
            copy[i] = points[i];
        }
        Arrays.sort(copy);
        int rank = 0;
        for(int v:copy){
            if(!map.containsKey(v)){
                map.put(v,rank);
                rank++;
            }
        }
        StringBuilder sb = new StringBuilder();
            for(int key:points){
                sb.append(map.get(key)).append(" ");
            }
        System.out.println(sb);
    }
}