import java.util.Arrays;
class Solution {
    public long solution(long n) {
        long arr[] = new long [String.valueOf(n).length()];
        long result = 0;
        for(int i =0;i<arr.length;i++){
            arr[i] = n%10;
            n/=10;
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            result+=Math.pow(10,i)*arr[i];
        }
        return result;
    }
}