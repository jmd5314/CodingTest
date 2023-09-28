import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String st = sc.next();
        String str[] = st.split("");
        int sum = 0;
        for(String s:str){
            sum+=Integer.parseInt(s);
        }
        System.out.println(sum);
    }
}