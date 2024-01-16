import java.io.*;
import java.util.*;
public class Main{
    public static int min = Integer.MAX_VALUE;
    public static int S[][];
    public static int N;
    public static boolean visit[];
    public static void diff(){
        int start_score = 0;
        int link_score = 0;
        for(int i =0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(visit[i]&&visit[j]){
                    start_score += S[i][j];
                    start_score += S[j][i];
                }
                else if(!visit[i]&&!visit[j]){
                    link_score += S[i][j];
                    link_score += S[j][i];
                }
            }
        }
        if(Math.abs(start_score-link_score)<min){
            min = Math.abs(start_score-link_score);
        }
    }
    public static void start_link(int idx,int d){
        if(d==N/2){
            diff();
            return;
        }
        for(int i =idx;i<N;i++){
            //방문하지 않았다면?
            if(!visit[i]){
                visit[i] = true; //방문으로 변경
                start_link(i+1,d+1); //재귀 호출
                visit[i] = false; //재귀가 끝나면 방문x 로 변경
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visit = new boolean[N];
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
                S[i][j] = Integer.parseInt(st.nextToken());
        }
        start_link(0,0);
        System.out.println(min);
    }
}