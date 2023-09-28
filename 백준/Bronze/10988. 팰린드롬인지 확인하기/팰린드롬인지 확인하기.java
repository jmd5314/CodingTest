import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();
        if(s1.equals(s2))
            System.out.println(1);
        else
            System.out.println(0);
}
}