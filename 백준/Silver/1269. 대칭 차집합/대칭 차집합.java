import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();
        for(int i =0;i<A;i++){
            mapA.put(sc.nextInt(),0);
        }
        for(int i =0;i<B;i++){
            int num = sc.nextInt();
            if(mapA.containsKey(num))
                mapA.remove(num);
            else
                mapB.put(num, 0);
        }
        System.out.println(mapA.size()+mapB.size());
    }
}