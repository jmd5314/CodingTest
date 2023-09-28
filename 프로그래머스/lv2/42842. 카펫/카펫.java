class Solution {
    public int[] solution(int brown, int yellow) {
        int answer[] =new int[2];
        int s = brown/2+2;
        for(int w = Math.max(s/2,s-s/2);w<s;w++){
            int h = s-w;
            if(yellow==(w-2)*(h-2)){
                answer[0] = w;
                answer[1] = h;
                break;
            }
        }
        return answer;
    }
}