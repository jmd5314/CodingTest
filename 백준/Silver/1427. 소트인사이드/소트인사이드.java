import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.next().split("");
        StringBuilder sb = new StringBuilder();
        Arrays.sort(str,(v1,v2)->Integer.parseInt(v2)-Integer.parseInt(v1));
        for(String s:str){
            sb.append(s);
        }
        System.out.println(sb.toString());
    }
}