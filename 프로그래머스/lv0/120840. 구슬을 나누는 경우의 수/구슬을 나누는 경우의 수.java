class Solution {
    public int solution(int balls, int share) {
        return combination(balls,share);
    }
    public int combination(int n, int c){
        if(n==c||c==0)
            return 1;
        else
            return combination(n-1,c)+combination(n-1,c-1);
    }
}