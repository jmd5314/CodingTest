import java.io.*;
import java.util.*;
public class Main{
    //arr 배열의 index 는 체스판의 열, 배열 값은 행을 의미함
    public static int arr[];
    public static int N;
    public static int count =0;
    public static void N_queen(int d){
        if(d==N) {
            count++;
            return;
        }
        for(int i =0;i<N;i++){
            arr[d] = i;
            if(Possible(d)){
                N_queen(d+1);
            }
        }

    }
    //놓을 위치가 다른 퀸으로부터 위협 받는지 검사하는 함수
    private static boolean Possible(int col) {
        for(int i=0;i<col;i++){
            //해당 열의 행과 i열의 행이 존재할 경우 (같은 행에 존재할 경우) i는 col 보다 낮은 수들
            if(arr[col]==arr[i]) 
                return false;
            // 대각선 인지 검수
            else if(Math.abs(col-i)==Math.abs(arr[col]-arr[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        N_queen(0);
        System.out.println(count);
    }
}