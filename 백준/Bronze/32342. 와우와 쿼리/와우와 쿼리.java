import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        String[] s = new String[Q];
        int[] result = new int[Q];
        for (int i = 0; i < Q; i++) {
            s[i] = br.readLine();
        }
        for (int i = 0; i < Q; i++) {
            for (int j = 0; j < s[i].length() - 2; j++) {
                if (s[i].charAt(j) == 'W' && s[i].charAt(j + 1) == 'O' && s[i].charAt(j + 2) == 'W') {
                    result[i]++;
                }
            }
        }
        for (int r : result) {
            System.out.println(r);
        }
    }
}