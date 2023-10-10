import java.util.Scanner;
public class Main {
    private static boolean isPrime(int n){
        int count = 0;
        for(int i=1;i<=n;i++){
            if(n%i==0)
                count++;
        }
        if(count==2)
            return true;
        return false;
    }
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int N = sc.nextInt();
        int num[] = new int [N];
        for(int i=0;i<N;i++){
            num[i]=sc.nextInt();
            if(isPrime(num[i]))
                result++;
        }
        System.out.println(result);
    }
}