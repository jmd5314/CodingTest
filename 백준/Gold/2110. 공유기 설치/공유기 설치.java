import java.io.*;
import java.util.*;

public class Main {
    public static int point[];
    public static int Install(int distance){
        // 첫번째 집은 무조건 설치
        int count = 1;
        int lastLocate = point[0];
        for(int i =1;i<point.length;i++){
            if(point[i]-lastLocate>=distance){
                count++;
                lastLocate = point[i];
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        point = new int[N];
        for(int i =0;i<N;i++){
            point[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(point);
        int lo = 1; //최소 거리가 가질 수 있는 최솟값
        int hi = point[N-1]-point[0]+1; // 최소 거리가 가질 수 있는 최댓값
        while (lo<hi){
            int mid = (lo+hi)/2;
            // 설치할 수 있는 공유기가 C 개수에 못 미치면 거리를 좁혀야 함
            if(Install(mid)<C){
                hi = mid;
            }
            // 반대의 경우 최소 거리가 가질 수 있는 최댓값을 찾아야 하므로 거리를 넓힘
            else{
                lo = mid+1;
            }
        }
        // UpperBound 이기 때문에 -1
        System.out.println(lo-1);
    }
}