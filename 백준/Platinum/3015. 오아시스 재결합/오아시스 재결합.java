import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static Stack<Pair> stack = new Stack<>();
    static long count = 0;
    public static class Pair{
        int height;
        int cnt;
        Pair(int height,int cnt){
            this.height = height;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i =0;i<N;i++){
            int height = Integer.parseInt(br.readLine());
            Pair pair = new Pair(height, 1);
            // stack top 사람의 키가 새로 줄 서는 사람의 키보다 같거나 작은 경우 pop
            while (!stack.isEmpty()&&stack.peek().height<=pair.height){
                Pair pop = stack.pop();
                count += pop.cnt;
                // 키가 같은 경우에는 새로 줄 서는 사람의 count 를 증가
                if(pop.height==pair.height){
                    pair.cnt += pop.cnt;
                }
            }
            // 작거나 같은 키들을 다 세고 더 큰 키도 볼 수 있기때문에 pop 을 다 한뒤 stack 이 비지 않는다면 count +1 해주어야 함
            if(!stack.isEmpty()){
                count++;
            }
            // 새로 줄 서는 사람 push
            stack.push(pair);
        }
        System.out.println(count);
    }
}