import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        int count = 0;
        int start = 0;
        int end = n-1;
        int sum = 0;
        Arrays.sort(arr);
        while (start<end){
            sum = arr[start] + arr[end];
            if(sum==x)
                count++;
            // sum=x 일때가 끝나는 조건은 아니기 때문에 <=의 조건을 단다
            if(sum<x)
                start++;
            else
                end--;
        }
        System.out.println(count);
    }
}