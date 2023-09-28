import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int alpha[] = new int[26];
        int max = 0;
        char result=0;
        String s = sc.next();
        s = s.toUpperCase();
        for(int i =0;i<s.length();i++){
            int index = s.charAt(i)-'A';
            alpha[index]++;
        }
        for(int i =0;i<26;i++){
            if(alpha[i]>max){
                max = alpha[i];
                result = (char)('A'+i);
            }
            else if(max==alpha[i])
                result = '?';
        }
        System.out.println(result);
    }
}