import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int result=0;
        String s = sc.next();
        s=s.replaceAll("[ABC]","2");
        s=s.replaceAll("[DEF]","3");
        s=s.replaceAll("[GHI]","4");
        s=s.replaceAll("[JKL]","5");
        s=s.replaceAll("[MNO]","6");
        s=s.replaceAll("[PQRS]","7");
        s=s.replaceAll("[TUV]","8");
        s=s.replaceAll("[WXYZ]","9");
        for(String ss:s.split("")){
            result += Integer.parseInt(ss) + 1;
        }
        System.out.println(result);
}
}
