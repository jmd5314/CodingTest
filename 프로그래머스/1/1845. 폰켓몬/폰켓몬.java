import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int N = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        return map.size()>N/2?N/2:map.size();
    }
}