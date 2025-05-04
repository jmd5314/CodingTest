import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> max_q = new PriorityQueue<>((o1,o2)->(o2-o1));
        PriorityQueue<Integer> min_q = new PriorityQueue<>();
        for(String o : operations){
            if(o.startsWith("I")){
                int num = Integer.parseInt(o.substring(2));
                max_q.offer(num);
                min_q.offer(num);
            }
            else if(o.equals("D -1")){
                if(min_q.isEmpty()){
                    continue;
                }
                else{
                    Integer min = min_q.poll();
                    max_q.remove(min);
                }
            }
            else{
                   if(min_q.isEmpty()){
                    continue;
                }
                    else{
                       Integer max = max_q.poll();
                        min_q.remove(max);
                }
            }
        }
        if(min_q.isEmpty()){
            return new int[]{0,0};
        }
        return new int[]{max_q.poll(),min_q.poll()};
    }
}