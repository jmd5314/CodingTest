import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean [] isPrime;
    static List<Integer> list = new ArrayList<>();
    public static void prime(){
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2;i*i<=N;i++){
            if (isPrime[i]){
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i=1;i<=N;i++){
            if(isPrime[i])
                list.add(i);
        }
        // end 전까지의 합이기때문에 인덱스가 하나 더 필요함
        list.add(0);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        isPrime = new boolean[N + 1];
        prime();
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        while (start <= end && end < list.size()) {
            if(sum<N){
                sum += list.get(end++);
            }
            else{
                if(sum==N)
                    count++;
                sum -= list.get(start++);
            }
        }
        System.out.println(count);
    }
}