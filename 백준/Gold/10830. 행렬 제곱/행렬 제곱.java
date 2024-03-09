import java.io.*;
import java.util.*;

public class Main {
    static long result[][];
    static int N;
    // 행렬 곱 연산 함수
    public static long[][] con(long [][] tmp1,long[][] tmp2){
        long[][] matrix = new long[N][N];
        for(int i =0;i<N;i++){
            for(int j =0;j<N;j++){
                long sum = 0;
                for(int k=0;k<N;k++){
                    sum += (tmp1[i][k]*tmp2[k][j])%1000;
                }
                matrix[i][j] = sum;
            }
        }
        return matrix;
    }
    // 행렬 나머지 연산함수
    public static long[][] div(long[][] tmp){
        long[][] matrix = new long[N][N];
        for(int i =0;i<N;i++){
            for(int j=0;j<N;j++){
                matrix[i][j] = tmp[i][j]%1000;
            }
        }
        return matrix;
    }
    public static long[][] sqt(long[][] A, long B){
        if(B==1){
            return div(A);
        }
        long [][]tmp = sqt(A, B / 2);
        // B가 홀수인 경우 ((tmp*tmp)*A)%1000을 반환
        if(B%2==1)
            return div(con(con(tmp,tmp),A));
        // B가 짝수인 경우 (tmp*tmp)%1000을 반환
        return div(con(tmp,tmp));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long [][] A = new long[N][N];
        result = new long[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Long.parseLong(st.nextToken());
            }
        }
        A = sqt(A, B);
        for(int i =0;i<N;i++){
            for(int j =0;j<N;j++){
                sb.append(A[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}