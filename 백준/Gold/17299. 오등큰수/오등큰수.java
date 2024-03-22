import java.io.*;
import java.util.*;
/*
* 오큰수 문제와 같은 풀이에서 각 수의 count 값으로 비교하는 로직만 추가 
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num[] = new int[N];
        int count[] = new int[10000001];
        for(int i =0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
            count[num[i]]++;
        }
        for(int i =0;i<N;i++){
            while(!stack.isEmpty()&&count[num[i]]>count[num[stack.peek()]]){
                num[stack.pop()] = num[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            num[stack.pop()] = -1;
        }
        for(int i =0;i<num.length;i++){
            sb.append(num[i]).append(" ");
        }
        System.out.println(sb);
        }
    }