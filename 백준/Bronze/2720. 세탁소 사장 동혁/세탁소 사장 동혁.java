import java.util.Scanner;
public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i =0;i<T;i++){
            int n =sc.nextInt();
            int num[] = new int [4];
            while(n>0){
                if(n>=25){
                    num[0] = n/25;
                    n %= 25;
                }
                else if(n<25&&n>=10){
                    num[1] = n/10;
                    n%=10;
                }
                else if(n<10&&n>=5){
                    num[2] = n/5;
                    n%=5;
                }
                else{
                    num[3] = n/1;
                    n%=1;
                }
            }
            System.out.println(num[0]+" "+num[1]+" "+num[2]+" "+num[3]);
        }
    }
}