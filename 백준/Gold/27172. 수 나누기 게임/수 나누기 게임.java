import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] player = new int[N];
        // 최대 수가 1000000 이므로
        int[] point = new int[1000001];
        boolean[] num = new boolean[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = 0;
        for(int i =0;i<N;i++){
            player[i] = Integer.parseInt(st.nextToken());
            num[player[i]] = true;
            if(player[i]>size)
                size = player[i];
        }
        for(int i =0;i<N;i++){
            // 각 플레이어의 수 마다 최대 size 까지 해당 수의 배수가 존재하면 점수 증가 배수는 점수 감소
            for(int j =player[i]*2;j<=size;j+=player[i]){
                if(num[j]) {
                    point[player[i]]++;
                    point[j]--;
                }
            }
        }
        for(int i =0;i<N;i++){
            sb.append(point[player[i]]).append(" ");
        }
        System.out.println(sb);
    }
}