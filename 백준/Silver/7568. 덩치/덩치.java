import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int N = Integer.parseInt(br.readLine());
        int[][] build = new int[N][2];
        int[] rank = new int[N];
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            build[i][0] = Integer.parseInt(st.nextToken());
            build[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i =0;i<N;i++){
            int count = 0;
            for(int j=0;j<N;j++){
                if(i==j)
                    continue;
                if(build[i][0]<build[j][0]&&build[i][1]<build[j][1]){
                    count++;
                }
            }
            rank[i] = count + 1;
        }
        for(int r:rank){
            System.out.print(r + " ");
        }
    }
}