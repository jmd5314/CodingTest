import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        int len = numlist.length;
        int result [] = new int [len];
        double arr [] = new double [len];
        for(int i = 0;i<len;i++){
            if(numlist[i]-n<0)
                arr[i] = Math.abs(numlist[i]-n)+0.5;
            else
                arr[i] = Math.abs(numlist[i]-n);
        }
        Arrays.sort(arr);
        for(int i =0;i<len;i++){
            if(arr[i]%1!=0)
                result[i] = n-(int)(arr[i]);
            else
                result[i] = n+(int)arr[i];
        }
        return result;
}
}