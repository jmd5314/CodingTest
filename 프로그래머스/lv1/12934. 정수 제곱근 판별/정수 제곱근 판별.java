class Solution {
    public long solution(long n) {
        long i = (long)Math.sqrt(n);
        if(i*i==n)
            return (i+1)*(i+1);
        else
            return -1;
    }
}