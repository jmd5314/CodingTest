import java.util.*;
class Solution {
    static int count = 0;
    private void dfs(int idx, int current, int[]numbers, int target){
        if(idx == numbers.length){
               if(current == target){
            count++;
        }
            return;
        }
        dfs(idx+1,current + numbers[idx],numbers,target);
        dfs(idx+1,current - numbers[idx],numbers,target);
    }
    public int solution(int[] numbers, int target) {
        dfs(0,0,numbers,target);
        return count;
    }
}