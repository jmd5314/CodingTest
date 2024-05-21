import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        for(int i =0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            // 0보다 크면 plus 저장 작으면 minus 저장
            if(num>0)
                plus.add(num);
            else
                minus.add(num);
        }
        // 양수는 내림차순 정렬, 음수는 오름차순 정렬
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);
        int result = 0;
        for(int i =0;i<plus.size();i+=2){
            // 마지막 수인 경우 그냥 더해줌
            if(i+1>=plus.size()){
                result += plus.get(i);
            }
            /* 더한 값과 곱한 값 중 더 큰 값을 저장함
             * 1,2 의 경우 곱한 값 보다 더한 값이 크기 때문
             */
            else {
                result += Math.max(plus.get(i) + plus.get(i + 1), plus.get(i) * plus.get(i + 1));
            }
        }
        for(int i =0;i<minus.size();i+=2){
            // 마지막 수인 경우 그냥 더해줌
            if(i+1>=minus.size()){
                result += minus.get(i);
            }
            // 음수의 경우 무조건 서로 곱하는 값이 더 큼
            else {
            result += minus.get(i) * minus.get(i + 1);
            }
        }
        System.out.println(result);

    }
}