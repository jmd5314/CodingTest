import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-->0){
            String word = br.readLine();
            char[] ch = word.toCharArray();
            char[] copy = Arrays.copyOf(ch, ch.length);
            int[] index = new int[copy.length];
            Arrays.sort(ch);
            // 각 알파벳 순서 값 저장
            for(int i =0;i<copy.length;i++){
                for(int j =0;j<ch.length;j++){
                    if(copy[i]==ch[j])
                        index[i] = j;
                }
            }
            for(int i =copy.length-1;i>0;i--){
                // 증가하는 부분을 찾으면
                if(index[i]>index[i-1]){
                    //그 곳을 기점으로 맨 뒤에서 부터 좌측 맨 끝 수보다 큰수를 탐색
                    for(int j=copy.length-1;j>i-1;j--){
                        // 찾으면 교환
                        if(index[j]>index[i-1]){
                            char tmp = copy[i - 1];
                            copy[i - 1] = copy[j];
                            copy[j] = tmp;
                            Arrays.sort(copy,i,copy.length);
                            break;
                        }
                    }
                    break;
                }
            }
            for(char c:copy){
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}