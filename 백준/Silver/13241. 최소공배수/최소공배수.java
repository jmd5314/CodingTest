import java.util.*;
public class Main {
    private static long gcd(long A,long B){
        while (B!=0){
            long temp = B;
            B = A%B;
            A=temp;
        }
        return A;
    }
    private static long lcm(long A,long B){
        return Math.abs(A * B) / gcd(A, B);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        System.out.println(lcm(A,B));
    }
}