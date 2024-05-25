import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int N = Integer.parseInt(br.readLine());
            int[][] score = new int[N][2];
            for(int i =0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                score[i][0] = Integer.parseInt(st.nextToken());
                score[i][1] = Integer.parseInt(st.nextToken());
            }
            // 서류 점수 기준 오름 차순 정렬
            Arrays.sort(score,(o1,o2)->{
                return o1[0] - o2[0];
            });
            // 서류 점수 1등은 채용 서류 점수 1등의 면접 등수를 최소 등수로 초기화
            int count = 1;
            int min = score[0][1];
            for(int i=1;i<N;i++){
                // 만약 지금 등수가 이전 최소 면접 등수 보다 높은 등수라면 count 후 최소 면접 등수를 갱신 해줌
                if(score[i][1]<min){
                    count++;
                    min = score[i][1];
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}