class Solution {
    public int[] solution(long n) {
        int result [] = new int [String.valueOf(n).length()];
        int index = 0;
        while(n>0){
                result[index] =(int)(n%10);
                n/=10;
                index++;
        }
        return result;
    }
}