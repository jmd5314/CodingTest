class Solution {
    public int solution(String A, String B) {
        int result = 0;
        int len = A.length();
        for(int i=0;i<len-1;i++){
            if(A.equals(B))
                break; 
            else{
            A = A.substring(len-1)+A.substring(0,len-1);
            result++;
            }
        }
        if(!A.equals(B))
            result = -1;
        return result;
    }
}