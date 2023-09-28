class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int v = x;
        while(v>0){
            sum+=v%10;
            v/=10;
        }
        return x%sum==0?true:false;
    }
}