class Solution {
    public int[] solution(int num, int total) {
        int result [] = new int[num];
        for(int i =0;i<num;i++)
            total-=i;
        int x = total/num;
        for(int i =0;i<num;i++)
            result[i] = x+i;
        return result;
    }
}