import java.util.*;
import java.io.*;

public class Main {
    static int ans = 0;
    static String S;
    static String T;
    public static void dfs(String s, String t, int idx) {
        if(idx>=s.length()||idx>=t.length()){
            if(idx>ans){
                ans = idx;
                S = s;
                T = t;
            }
        }
        else {
            if (s.charAt(idx) == t.charAt(idx)) {
                dfs(s, t, idx + 1);
                return;
            } else {
                if (idx > ans) {
                    ans = idx;
                    S = s;
                    T = t;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                dfs(words[i], words[j], 0);
            }
        }
        System.out.println(S);
        System.out.println(T);
    }
}