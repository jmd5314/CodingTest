class Solution {
    public int[] solution(int brown, int yellow) {
        int [] answer = new int[2];
        for(int i = 1;i <= yellow; i++){
            if(yellow % i != 0)
                continue;
            int w = Math.max(i,yellow/i);
            int h = yellow/w;
            if(brown == 2*w+2*h+4){
                answer[0] = w+2;
                answer[1] = h+2;
                break;
            }
        }
        return answer;
    }
}