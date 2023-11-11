import java.util.*;
public class Main {
    private static boolean isPrime(long N){
        if(N<2)
            return false;
        for(int i =2;i<=Math.sqrt(N);i++){
            if(N%i==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int M = sc.nextInt();
        int N = sc.nextInt();
        for(int i =M;i<=N;i++){
            if(isPrime(i))
                sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}