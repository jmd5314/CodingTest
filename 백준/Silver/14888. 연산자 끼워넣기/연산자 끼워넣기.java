import java.io.*;
import java.util.*;
public class Main{
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;
    public static int N;
    public static int number[];
    public static int operator[] = new int[4];
    public static void insertOpt(int num,int idx){
        if(idx==N){
            if(min>num)
                min = num;
            if(max<num)
                max = num;
        }
        for(int i =0;i<4;i++){
            //연산자 개수가 1개 이상인 경우
            if(operator[i]>0){
                //해당 연산자 수 감소
                operator[i]--;
                switch (i){
                    case 0 : insertOpt(num+number[idx],idx+1);break;
                    case 1 : insertOpt(num-number[idx],idx+1);break;
                    case 2 : insertOpt(num*number[idx],idx+1);break;
                    case 3: insertOpt(num/number[idx],idx+1);break;
                }
                //재귀 호출이 종료 되면 다시 해당 연산자 개수를 복구한다.
                operator[i]++;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        number = new int[N];
        for(int i =0;i<N;i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<4;i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }
        insertOpt(number[0],1);
        System.out.println(max);
        System.out.println(min);
    }
}