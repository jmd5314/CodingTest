import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        String first = br.readLine();
        for(int i =0;i<N-1;i++){
            String word = br.readLine();
            int cnt = 0; // 같은 단어 개수
            int[] alpha = new int[26];
            // 첫번째 단어의 각 알파벳 개수 저장
            for(int j =0;j<first.length();j++){
                alpha[first.charAt(j) - 'A']++;
            }
            for(int j =0;j<word.length();j++){
                // 같은 알파벳 있을때마다 cnt 증가
                if(alpha[word.charAt(j)-'A']>0){
                    cnt++;
                    alpha[word.charAt(j)-'A']--;
                }
            }
            // 같은 알파벳일때 혹은 하나 추가되었을때
            if(cnt==first.length()&&word.length()-first.length()<2)
                count++;
            // 하나 제거 된 경우
            else if(cnt==word.length()&&first.length()-word.length()==1)
                count++;
            // 하나 바뀐 경우
            else if(first.length()-cnt==1&&first.length()==word.length())
                count++;
        }
        System.out.println(count);
    }
}