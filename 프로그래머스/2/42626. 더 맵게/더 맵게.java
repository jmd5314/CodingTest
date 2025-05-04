import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville){
            pq.offer(i);
        }
        int count = 0;
        while(pq.size()>=2){
            if(pq.peek()<K){
                int s1 = pq.poll();
                int s2 = pq.poll();
                pq.offer(s1+2*s2);
                count++;
            }
            else{
                break;
            }
        }
        if(pq.peek()>=K)
            return count;
        return -1;
    }
}