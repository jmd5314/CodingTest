import java.util.*;
class Solution {
    public int solution(int[] sides) {
        int result = 0;
        Arrays.sort(sides);
        for(int i =sides[1];sides[1]<i+sides[0];i--)
            result++;
        for(int i=sides[1]+1;i<sides[0]+sides[1];i++)
            result++;
        
        return result;
    }
}