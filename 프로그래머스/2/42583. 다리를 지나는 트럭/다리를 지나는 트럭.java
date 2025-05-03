import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<bridge_length;i++){
            q.offer(0);
        }
        int sum = 0;
        int idx = 0;
        while(idx < truck_weights.length){
            // 1초 경과
            answer++;
            // 다리에서 트럭 한대 나감
            sum-=q.poll();
            // 만약 트럭을 올려도 무게가 초과되지 않으면
            if(truck_weights[idx] + sum <= weight){
                q.offer(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
            }
            // 초과 되면 빈 트럭 올리기
            else{
                q.offer(0);
            }
        }
        // 위의 while 문은 트럭을 다 올리면 종료되기 때문에 마지막 트럭이 건너는 시간을 더해줘야 함
        return answer+bridge_length;
    }
}