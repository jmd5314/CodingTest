import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N  = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long count = 0;
        int num[] = new int[N];
        int rem[] = new int[M];
        st = new StringTokenizer(br.readLine());
        // 처음 수 초기화
        num[0] = Integer.parseInt(st.nextToken())%M;
        rem[num[0]]++;
        for(int i =1;i<N;i++){
            // 누적합 % M 저장
            num[i] = (num[i-1]+Integer.parseInt(st.nextToken()))%M;
            // 해당 나머지 값 저장
            rem[num[i]]++;
        }
        // 0인 수만큼 count 증가
        count+=rem[0];
        for(int i=0;i<M;i++){
            // 각 나머지 값들의 횟수들 중 2개를 고르면 각 숫자의 count 값이 된다.
            count+=(long)rem[i]*(rem[i]-1)/2;
        }
        System.out.println(count);
    }
}