import java.io.*;
import java.util.*;
public class Main{
    // a,b,c 중 하나라도 0보다 작으면 1을 리턴하기 때문에 dp의 각 index 는 0~20까지의 수만 가지면 된다.
    public static int dp[][][] = new int[21][21][21];
    public static int w(int a,int b,int c){
        if(isRange(a,b,c)&&dp[a][b][c]!=0)
            return dp[a][b][c];
        if(a<=0||b<=0||c<=0){
            return 1;
        }
        if(a>20||b>20||c>20){
            return dp[20][20][20] = w(20,20,20);
        }
        if(a<b&&b<c){
            return dp[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
        }
        else{
            return dp[a][b][c] = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
        }
    }
    public static boolean isRange(int a,int b,int c){
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a,b,c;
        while (true){
        StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a==-1&&b==-1&&c==-1)
                break;
            System.out.println("w("+a+", "+b+", "+c+") = "+w(a,b,c));
        }
    }
}