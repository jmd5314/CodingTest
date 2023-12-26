import java.util.Scanner;

public class Main {
    private static int countN(long N){
        int count = 0;
        for(long k=2;k*(k+1)/2<=N;k++){
            if((N-k*(k+1)/2)%k==0)
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i =0;i<T;i++){
            long N = sc.nextLong();
            System.out.println(countN(N));
        }
    }
}
