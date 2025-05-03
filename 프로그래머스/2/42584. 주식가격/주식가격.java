class Solution {
    public int[] solution(int[] prices) {
        int [] answer = new int [prices.length];
        for(int i = 0; i < answer.length-1; i++){
            int count = 0;
            for(int j = i + 1;j<answer.length;j++){
                if(prices[j]>=prices[i])
                    count++;
                else{
                    count++;
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}