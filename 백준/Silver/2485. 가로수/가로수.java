import java.util.*;
public class Main {
    private static int findGcd(int a,int b){
        while(b!=0){
            int tmp = b;
            b = a%b;
            a=tmp;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int arr[] = new int[N];
        for(int i =0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        int gcd = 0;
        for(int i =1;i<N;i++){
            int x = arr[i] - arr[i - 1];
            gcd = findGcd(gcd, x);
        }
        int entire = (arr[N - 1] - arr[0]) / gcd + 1;
        System.out.println(entire - arr.length);
    }
}