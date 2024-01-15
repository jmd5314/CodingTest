import java.io.*;
public class Main{
    static StringBuilder sb = new StringBuilder();
    /*
    N: 원판의 개수
    start: 출발지
    mid : 중간 경유지
    to : 목적지
     */
    public static void Hanoi(int N,int start,int mid,int to) {
        if(N==1){
            sb.append(start+" "+to+"\n");
            return;
        }
        //A->C로 이동할때
        // N-1개를 A에서 B로 이동시킨다
        Hanoi(N-1,start,to,mid);
        // 1개를 A에서 C로 이동
        Hanoi(1,start,mid,to);
        // N-1개 B에서 C로 이동
        Hanoi(N-1,mid,start,to);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((int) Math.pow(2, N) - 1).append("\n");
        Hanoi(N,1,2,3);
        System.out.println(sb);
    }
}