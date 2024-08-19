import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        long count = 0;
        Set<Integer> set = new HashSet<>();
        int end = 0;

        for (int start = 0; start < N; start++) {
            while (end < N && !set.contains(num[end])) {
                set.add(num[end]);
                end++;
            }
            count += end - start;
            set.remove(num[start]);
        }

        System.out.println(count);
    }
}