import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = N;
        String s[] = new String[N];
        for(int i =0;i<N;i++){
            boolean alpha[] = new boolean[26];
            s[i] = sc.next();
            char[] chars = s[i].toCharArray();
            for(int j=0;j<chars.length;j++){
                int index = chars[j] - 'a';
                if(!alpha[index])
                    alpha[index] = true;
                else if(alpha[index]){
                    if(chars[j-1]==chars[j])
                        continue;
                    else{
                        result--;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}