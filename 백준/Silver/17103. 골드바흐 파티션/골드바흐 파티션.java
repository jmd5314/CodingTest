import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        boolean num[] = new boolean[1000001];
        num[0] = true;
        num[1] = true;
        for(int i=2;i<=1000000;i++){
            if(!num[i]){
                for(int j =i+i;j<=1000000;j+=i)
                    num[j] = true;
            }
        }
        int T = sc.nextInt();
        for(int i =0;i<T;i++){
            int N = sc.nextInt();
            int count = 0;
            for(int j=2;j<=N/2;j++){
                if(!num[j]&&!num[N-j])
                    count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}