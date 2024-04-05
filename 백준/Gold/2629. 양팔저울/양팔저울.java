import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] result;
    static int N;
    static int weight[];
    // cnt 는 추의 갯수 num 은 현재 무게
    public static void dp(int cnt,int num){
        // 이미 방문한 값이면 그냥 return
        if(result[cnt][num])
            return;
        // 방문 표시
        result[cnt][num] = true;
        if(cnt==N) return;
        // 현재 추를 선택하고 합치는 경우
        dp(cnt+1,num+weight[cnt]);
        // 현재 추를 선택안하고 넘어가는 경우
        dp(cnt + 1, num);
        // 현재 추를 선택하고 빼는 경우
        dp(cnt + 1, Math.abs(num - weight[cnt]));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        weight = new int[N];
        // 추의 개수는 N까지 사용한 추의 개수를 의미하는 것은 아님, 총 무게는 40000까지
        result = new boolean[N + 1][40001];
        for(int i=0;i<N;i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }
        dp(0, 0);

        int M = Integer.parseInt(br.readLine());
        int[] ball = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<M;i++){
            ball[i] = Integer.parseInt(st.nextToken());
        }
        for(int i =0;i<M;i++){
            if(result[N][ball[i]])
                sb.append("Y").append(" ");
            else
                sb.append("N").append(" ");
        }
        System.out.println(sb);

    }
}