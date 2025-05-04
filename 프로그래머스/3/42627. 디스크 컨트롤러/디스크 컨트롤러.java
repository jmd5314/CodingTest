import java.util.*;
class Solution {
    
    public int solution(int[][] jobs) {
        // 요청 시간 순서대로 정렬
        Arrays.sort(jobs, (o1,o2)->(o1[0] - o2[0]));
        // 소요시간 순서대로 정렬
        PriorityQueue<int []> pq = new PriorityQueue<>((o1,o2)->(o1[1] - o2[1]));
        // 현재 시간
        int current = 0;
        // 총 소요시간
        int sum = 0;
        int idx = 0;
        while(idx < jobs.length || !pq.isEmpty()){
            while(idx < jobs.length && jobs[idx][0]<= current){
                // 현재 시점 기준으로 들어온 요청들을 대기 큐에 넣기
                pq.offer(new int[]{jobs[idx][0],jobs[idx][1]});
                idx++;
            }
            // 대기 큐에 있으면 꺼내기
            if(!pq.isEmpty()){
                int [] j = pq.poll();
                current += j[1];
                sum += current - j[0];
            }
            // 없으면 다음 요청 시간으로 초기화
            else{
                current = jobs[idx][0];
            }
        }
        return sum / jobs.length;
    }
}