import java.io.*;
import java.util.*;

public class Main {
    static int[] num;
    public static boolean binarySearch(int[] num, int n){
        int left = 0;
        int right = num.length-1;
        int mid;
        while (left<=right){
            mid = (left+right)/2;
            if(num[mid]<n)
                left = mid+1;
            else if(num[mid]>n)
                right = mid-1;
            else return true;
        }
        return false;
    }
    public static int isExist(int n){
        if(binarySearch(num,n))
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num); // 이분 탐색은 순서대로 정렬되있는 상태여야 함
        int M = Integer.parseInt(br.readLine());
        int[] val = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int n = Integer.parseInt(st.nextToken());
            val[i] = isExist(n);
            sb.append(val[i]).append("\n");
        }
        System.out.println(sb);
    }
}