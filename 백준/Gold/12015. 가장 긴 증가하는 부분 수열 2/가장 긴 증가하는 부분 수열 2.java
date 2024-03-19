import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num[] = new int[N];
        int LIS[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        // 초기 값은 첫번째 원소
        LIS[0] = num[0];
        int length = 1;
        for(int i =1;i<N;i++){
            int key = num[i];
            //만약 키 값이 LIS 배열의 마지막 수보다 크면 추가해준다.
            if(key>LIS[length-1]){
                length++;
                LIS[length-1] = key;
            }
            // 반대의 경우 이분탐색을 진행하여 대치한다
            else{
                int lo = 0;
                int hi = length;
                while (lo<hi){
                    int mid = (lo+hi)/2;
                    if(LIS[mid]<key){
                        lo = mid+1;
                    }
                    else{
                        hi = mid;
                    }
                }
                LIS[lo] = key;
            }
        }
        System.out.println(length);
    }
}