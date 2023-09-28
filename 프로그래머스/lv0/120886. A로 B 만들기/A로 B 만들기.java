import java.util.*;
class Solution {
    public int solution(String before, String after) {
        String strb [] = before.split("");
        String stra [] = after.split("");
        Arrays.sort(strb);
        Arrays.sort(stra);
        return Arrays.equals(strb,stra)?1:0;
        
    }
}