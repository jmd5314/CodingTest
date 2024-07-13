import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long count = 0;
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        for(int i =0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
        int [] AB = new int[n * n];
        int [] CD = new int[n * n];
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                AB[i * n + j] = A[i] + B[j];
                CD[i * n + j] = C[i] + D[j];
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);
        int start = 0;
        int end = n * n - 1;

        while (start<n*n&&end>-1){
            long ab = AB[start];
            long cd = CD[end];
            long sum = ab + cd;
            if(sum<0){
                start++;
            }
            else if(sum>0){
                end--;
            }
            else{
                long xc = 0;
                long yc = 0;
                // 합이 0이 되는 경우 같은 수가 있는지 탐색 다른 수면 while 문을 빠져나옴
                while (start < n * n && ab == AB[start]) {
                    start++;
                    xc++;
                }
                while (end > -1 && cd == CD[end]) {
                    end--;
                    yc++;
                }
                count += xc * yc;
            }
        }
        System.out.println(count);
    }
}