import java.util.*;
class Solution {
    public int[] solution(int[] emergency) {
        int arr [] = emergency.clone();
        int result [] = new int[emergency.length];
        Arrays.sort(emergency);
        for(int i =0;i<emergency.length;i++)
            for(int j=0;j<emergency.length;j++){
                if(arr[i]==emergency[j])
                    result[i]=emergency.length-j;
            }
        return result;        
    }
}