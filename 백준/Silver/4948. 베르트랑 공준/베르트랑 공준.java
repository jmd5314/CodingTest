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
        while(true){
            int n = sc.nextInt();
            if(n==0)
                break;
            int count = 0;
            for(int i =n+1;i<=2*n;i++){
                if(isPrime(i))
                    count++;
            }
            System.out.println(count);
        }
    }
}