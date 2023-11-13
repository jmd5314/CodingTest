import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;
        for(int i=1;i*i<=N;i++){
            sum++;
        }
        System.out.println(sum);
    }
}