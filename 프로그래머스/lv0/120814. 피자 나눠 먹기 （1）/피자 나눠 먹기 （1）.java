class Solution {
    public int solution(int n) {
        int i=n/7;
        int j=n%7;
        if(j==0)
            return i;
        else
            return i+1;
    }
}