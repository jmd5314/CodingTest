import java.util.Scanner;
public class Main {
    public static void main(String[] args)  {
        int count = 1;
        int num = 666;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while(N!=count){
            num++;

            if(String.valueOf(num).contains("666"))
                count++;
        }
        System.out.println(num);
    }
}
