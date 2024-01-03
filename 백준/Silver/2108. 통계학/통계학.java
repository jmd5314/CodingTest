import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num[] = new int[N];
        double sum = 0;
        int count[] = new int[8001];
        for(int i =0;i<N;i++) {
            num[i] = Integer.parseInt(br.readLine());
            sum += num[i];
            count[num[i]+4000]++;
        }
        int avg = (int)Math.round(sum/N);
        Arrays.sort(num);
        int mid = num[N / 2];
        int max = 0;
        int mode = 0;
        boolean isSecond = false;
        for(int i =0;i<8001;i++){
            if(count[i]>max){
                max = count[i];
                mode = i-4000;
                isSecond = false;
            }
            else if(count[i]==max&&!isSecond){
                mode = i-4000;
                isSecond = true;
            }
        }
        int range = num[N - 1] - num[0];
        System.out.println(avg);
        System.out.println(mid);
        System.out.println(mode);
        System.out.println(range);
    }
}