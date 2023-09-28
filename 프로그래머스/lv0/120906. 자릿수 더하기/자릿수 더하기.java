class Solution {
    public int solution(int n) {
        int sum=0;
        while(n>=1){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
}