import java.util.Scanner;
public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i =1;
        int s =1;
        while(s<n){
                s+=6*i;
                i++;
        }
        System.out.println(i);
    }
}