import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        String S = sc.next();
        int length = S.length();
        for(int i =0;i<length;i++){
            for(int j=i+1;j<=length;j++){
                set.add(S.substring(i, j));
            }
        }
        System.out.println(set.size());
    }
}