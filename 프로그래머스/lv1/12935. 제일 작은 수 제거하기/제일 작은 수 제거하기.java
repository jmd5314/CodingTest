import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        int result [] = new int[arr.length-1];
        if(arr.length==1)
            return new int[]{-1};
        for(int i:arr){
            if(i<=min)
                min=i;
        }
        for(int i:arr){
            if(i==min)
                continue;
            result[count++] = i;
        }
        return result;
    }
}