import java.util.*;
import java.io.*;
public class Main {
    public static int dfs(String S,String T){
        if(S.length()==T.length()){
            return S.equals(T) ? 1 : 0;
        }
        int ret = 0;
        // 맨 앞 문자가 B 인 경우 맨 앞 B 제거 후 뒤집기
        if(T.charAt(0)=='B'){
            StringBuilder t1 = new StringBuilder(T);
            ret += dfs(S, t1.deleteCharAt(0).reverse().toString());
        }
        /* 맨 뒤 문자가 B 인경우 맨 뒤 A 제거
         * BABA 와 같은 문자열의 경우엔 A를 제거하는게 맞는지 B를 제거 후 뒤집기가 맞는지
         * 모르기 때문에 될 수 있는 경우를 다 탐색하고, 그 값을 ret 에 더해줌
         */
        if(T.charAt(T.length()-1)=='A'){
            StringBuilder t2 = new StringBuilder(T);
            ret += dfs(S, t2.deleteCharAt(t2.length() - 1).toString());
        }
        // 한번이라도 성공하면 ret 은 0보다 큼
        return ret > 0 ? 1 : 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        System.out.println(dfs(S, T));
    }
}