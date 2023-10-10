import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a==0&b==0)
                break;
            if(b%a==0)
                list.add("factor");
            else if(a%b==0)
                list.add("multiple");
            else
                list.add("neither");
        }
        for(String s:list)
            System.out.println(s);
    }
}