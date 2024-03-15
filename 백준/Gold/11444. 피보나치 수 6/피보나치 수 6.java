import java.io.*;
import java.util.*;

public class Main {
    static long A[][] = {{1,1},{1,0}};
    //행렬 곱연산
    public static long[][] con(long[][]a,long[][]b){
        long matrix[][] = new long[2][2];
        for(int i =0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++){
                    matrix[i][j]+=(a[i][k]*b[k][j])%1000000007;
                    matrix[i][j]%=1000000007;
                }
            }
        }
        return matrix;
    }
    public static long[][] fib(long n){
        if(n==1||n==0)
            return A;
        /* ret으로 배열을 받아서 써야하는 이유
        * con(fibo(n/2),fibo(n/2)) 이런식으로 호출하게 되면 fibo(n/2)을 두번 호출 하게 되므로 분할정복이 아니게 된다
         */
        long ret[][] = fib(n / 2);
        if(n%2==1){
            return con(con(ret,ret),A);
        }
        return con(ret,ret);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(fib(n - 1)[0][0]);
    }
}