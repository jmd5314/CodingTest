class Solution {
    public int solution(int[] num_list) {
        int sum1 = 1;
        int sum2 = 0;
        for(int i:num_list){
            sum1*=i;
            sum2+=i;
        }
        return sum1<(int)Math.pow(sum2,2)?1:0;
    }
}