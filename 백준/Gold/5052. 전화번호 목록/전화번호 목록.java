import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-->0){
            int N = Integer.parseInt(br.readLine());
            String [] num = new String[N];
            for(int i = 0;i<N;i++){
                num[i] = br.readLine();
            }
            boolean result = false;
            /* 전화번호를 String 으로 저장한 뒤 오름차순으로 정렬 했기 때문에
             * 사전순으로 정렬 되므로 접두어가 같은 경우는 바로 맞닿아 있음
             * 접두어가 같은 경우가 가장 가까이에 있을 수 밖에 없음
             */
            Arrays.sort(num);
            for(int i =0;i<N-1;i++){
                // 바로 뒤의 전화번호가 현재 번호를 접두어로 가지는지를 확인한다
                if (num[i + 1].startsWith(num[i])) {
                    result = true;
                }
            }
            sb.append(result ? "NO" : "YES").append("\n");
        }
        System.out.println(sb);
    }
}