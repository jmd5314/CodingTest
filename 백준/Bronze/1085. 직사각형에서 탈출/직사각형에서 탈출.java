import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int num[] = {x,y,w-x,h-y};
        Arrays.sort(num);
        System.out.println(num[0]);
    }
}
