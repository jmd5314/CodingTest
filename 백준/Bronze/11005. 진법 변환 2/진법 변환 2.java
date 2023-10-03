import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String result = "";
        int N = sc.nextInt();
        int B = sc.nextInt();
        while(N>0){
            if(N%B>=10)
                result+=String.valueOf((char)(N%B-10+'A'));
            else
                result+=String.valueOf(N%B);
            N/=B;
        }
        StringBuilder sb = new StringBuilder(result);
        result = sb.reverse().toString();
        System.out.println(result);
    }
}