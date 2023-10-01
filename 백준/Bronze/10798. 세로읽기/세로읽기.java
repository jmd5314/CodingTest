import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String words[] = new String[5];
        String str[][] = new String [5][15];
        for(int i =0;i<5;i++){
            words[i] = sc.next();
            String s[] = words[i].split("");
            for(int j=0;j<words[i].length();j++){
                str[i][j] = s[j];
            }
        }
        for(int i =0;i<15;i++){
            for(int j=0;j<5;j++){
                if(str[j][i]!=null)
                    System.out.print(str[j][i]);
            }
        }
    }
}