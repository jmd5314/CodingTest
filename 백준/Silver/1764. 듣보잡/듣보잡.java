import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int N = sc.nextInt();
        int M = sc.nextInt();
        for(int i =0;i<N;i++){
            map.put(sc.next(), 0);
        }
        for(int i =0;i<M;i++){
            String see = sc.next();
            if (map.containsKey(see)) {
                list.add(see);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(String s:list){
            System.out.println(s);
        }
    }
}