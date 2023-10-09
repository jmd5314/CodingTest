import java.util.*;
public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<N;i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        for(int n:list) {
            sb.append(n).append("\n");
        }
        System.out.println(sb);
    }
}
