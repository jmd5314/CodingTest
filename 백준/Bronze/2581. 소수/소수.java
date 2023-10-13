import java.util.Scanner;
public class Main {
    private static boolean isPrime(int n){
        int count = 0;
        for(int i =1;i<=n;i++){
            if(n%i==0)
                count++;
        }
        if(count == 2)
            return true;
        return false;
    }
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int M = sc.nextInt();
        int N = sc.nextInt();
        for(int i =M;i<=N;i++){
            if(isPrime(i)){
                sum+=i;
            if(i<min)
                min = i;
            }
        }
        if(sum==0)
            System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
}