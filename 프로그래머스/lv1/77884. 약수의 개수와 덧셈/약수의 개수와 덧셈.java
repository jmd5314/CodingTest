class Solution {
    private boolean isDivisior(int num){
        int count = 0;
        for(int i=1;i<=num;i++){
            if(num%i==0)
                count++;
        }
        if(count%2==0)
            return true;
        return false;
    }
    public int solution(int left, int right) {
        int result = 0;
        for(int i =left;i<=right;i++){
            if(isDivisior(i))
                result+=i;
            else
                result+=(-1)*i;
        }
        return result;
    }
    
}