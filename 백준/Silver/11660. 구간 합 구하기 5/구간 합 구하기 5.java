import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N  = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int num [][] = new int[N][N];
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            // 행별로 누적합을 저장
            for(int j=0;j<N;j++){
                if(j==0)
                    num[i][j] = Integer.parseInt(st.nextToken());
                else
                    num[i][j] = num[i][j-1]+Integer.parseInt(st.nextToken());
            }
        }
        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            int result = 0;
            for(int j=x1;j<=x2;j++){
                if(y1==0)
                    result += num[j][y2];
                else
                    result += num[j][y2]-num[j][y1-1];
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}