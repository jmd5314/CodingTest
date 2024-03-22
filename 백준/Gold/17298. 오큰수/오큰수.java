import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num[] = new int[N];
        for(int i =0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        for(int i =0;i<N;i++){
            // 스택이 비어있지 않으면서 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 크면 스택을 pop 하면서 해당 인덱스 값을 현재 원소로 바꿔줌
            while(!stack.isEmpty() && num[stack.peek()] < num[i]) {
                num[stack.pop()] = num[i];
            }
            stack.push(i);
            }
        // 스택에 남아 있는 인덱스에 해당하는 원소들은 오큰수를 찾지 못한 원소들이므로 -1로 바꿔준다
        while(!stack.isEmpty()){
            num[stack.pop()] = -1;
        }
        for(int i =0;i<num.length;i++){
            sb.append(num[i]).append(" ");
        }
        System.out.println(sb);
        }
    }
