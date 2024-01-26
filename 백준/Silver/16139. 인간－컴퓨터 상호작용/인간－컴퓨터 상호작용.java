import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String S  = st.nextToken();
        st= new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        int length = S.length();
        int count[][] = new int[length][26];
        char ch [] = S.toCharArray();
        count[0][ch[0]-'a'] = 1;
        for(int i =1;i<length;i++){
            for(int j=0;j<26;j++){
                if(j==ch[i]-'a')
                    count[i][ch[i]-'a'] = count[i-1][ch[i]-'a']+1;
                else
                    count[i][j] = count[i-1][j];
            }
        }
        for(int i = 0;i<q;i++){
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if(l==0)
                sb.append(count[r][a-'a']).append("\n");
            else
                sb.append(count[r][a-'a'] - count[l-1][a-'a']).append("\n");
        }
        System.out.println(sb);
    }
}