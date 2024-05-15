import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            crane[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] box = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<M;i++){
            box[i] = Integer.parseInt(st.nextToken());
        }
        // 크레인 무게제한 내림차순 정렬
        Arrays.sort(crane, Collections.reverseOrder());
        // 박스 무게 오름차순 정렬
        Arrays.sort(box);
        Stack<Integer> stack = new Stack<>();
        // 스택에 박스 순서대로 추가
        for(int i =0;i<M;i++){
            stack.add(box[i]);
        }
        int count = 0;
        // 만약 가장 무거운 박스의 무게가 무게제한이 가장 높은 크레인 보다 높으면 모든 박스를 옮길 수 없기때문에 -1 출력
        if(stack.peek()>crane[0]){
            System.out.println(-1);
            System.exit(0);
        }
        while (!stack.isEmpty()){
            /* 가장 무거운 무게제한의 크레인 부터 가장 무거운 박스 순서대로 하나씩 할당 받음
             * 크레인 목록을 한바퀴 돌때마다 1분씩 추가
             */
            for(int i =0;i<N;i++){
                if(!stack.isEmpty()&&stack.peek()<=crane[i])
                    stack.pop();
                /* 최상단의 값이 만족하지 않는다면 그 다음 수부터 끝까지 탐색
                 * 단, 제일 작은 값과 비교해서 할당 받을 수 있는 수가 존재하는지 확인
                 */
                else if(!stack.isEmpty()&&stack.get(0)<=crane[i]){
                    int l = stack.size();
                    for(int j = l-2;j>=0;j--){
                        if(stack.get(j)<=crane[i]){
                            stack.remove(j);
                            break;
                        }
                    }
                }
            }
            count++;
        }
        System.out.println(count);
    }
}