import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int result = 0;
        Arrays.sort(citations);
        for(int i =0;i<citations.length;i++){
            if(citations[citations.length-i-1]>=i+1)
                result = i+1; 
        }
        return result;
    }
}