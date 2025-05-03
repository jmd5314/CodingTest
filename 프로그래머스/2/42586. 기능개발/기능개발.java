import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue <Integer> q = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        for(int i = 0;i< speeds.length;i++){
            int days = (100-progresses[i]) / speeds[i];
            int remain = (100-progresses[i]) % speeds[i];
            if(remain != 0)
                days+=1;
            q.offer(days);
        }
        while(!q.isEmpty()){
            int num = q.poll();
            int count = 1;
            while(!q.isEmpty()&&q.peek()<=num){
                q.poll();
                count++;
            }
            answer.add(count);
        }
        int [] result = new int[answer.size()];
        for(int i =0;i<result.length; i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}