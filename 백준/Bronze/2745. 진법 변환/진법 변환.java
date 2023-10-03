import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int result = 0;
        String N = sc.next();
        int B = sc.nextInt();
        for(int i =0;i<N.length();i++){
            if('A'<=N.charAt(i)&&N.charAt(i)<='Z'){
                result +=(10+(N.charAt(i)-'A'))*Math.pow(B,N.length()-1-i);
            }
            else
                result += (N.charAt(i)-'0') * Math.pow(B,N.length()-1-i);
        }
        System.out.println(result);
    }
}