import java.util.*;
public class Main {
    private static int gcd(int A,int B){
        while (B!=0){
            int temp = B;
            B = A%B;
            A=temp;
        }
        return A;
    }
    private static int lcm(int A,int B){
        return Math.abs(A * B) / gcd(A, B);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int i =0;i<T;i++){
        int A = sc.nextInt();
        int B = sc.nextInt();
        sb.append(lcm(A,B)).append("\n");
        }
        System.out.println(sb);
    }
}