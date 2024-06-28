import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans1 = arr[0];
        int ans2 = arr[N - 1];
        int start = 0;
        int end = N - 1;
        while (start<end){
            if (Math.abs(arr[start] + arr[end]) < Math.abs(ans1 + ans2)) {
                ans1 = arr[start];
                ans2 = arr[end];
            }
            if(arr[start]+arr[end]>0){
                end--;
            }
            else if(arr[start]+arr[end]<0){
                start++;
            }
            else{
                break;
            }
        }
        System.out.println(ans1+" "+ans2);
    }
}