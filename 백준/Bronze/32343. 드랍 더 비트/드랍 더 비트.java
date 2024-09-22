import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int A = Math.min(a, N - b);
        int B = Math.min(b, N - a);
        int sum = A + B;
        double result = 0;
        for (int i = 1; i <= sum; i++) {
            result += Math.pow(2, N - i);
        }
        System.out.println((int)result);
    }
}