import java.util.Scanner;
public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();
        double x = (double) (V-A)/(A-B);
        int result = 0;
        if(x%1>0)
            result = (int)x+2;
        else
            result = (int)x+1;
        System.out.println(result);
    }
}