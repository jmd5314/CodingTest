class Solution {
    public int solution(int slice, int n) {
        int i = n/slice;
        int j = n%slice;
        if(j==0)
            return i;
        else
            return i+1;
    }
}