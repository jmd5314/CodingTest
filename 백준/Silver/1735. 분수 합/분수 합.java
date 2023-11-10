import java.util.*;
public class Main {
    public static int gcd(int a,int b){
        while(b!=0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        int X = B*C+A*D;
        int Y = B*D;
        int n = gcd(X,Y);
        System.out.println(X/n+" "+Y/n);
    }
}