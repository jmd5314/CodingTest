import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s=s.replace("c=","1");
        s=s.replace("c-","1");
        s=s.replace("dz=","1");
        s=s.replace("d-","1");
        s=s.replace("lj","1");
        s=s.replace("nj","1");
        s=s.replace("s=","1");
        s=s.replace("z=","1");
        System.out.println(s.length());
    }
}