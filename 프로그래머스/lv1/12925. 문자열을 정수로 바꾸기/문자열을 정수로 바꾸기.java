class Solution {
    public int solution(String s) {
        if(s.charAt(0)=='-')
            return Integer.valueOf(s.substring(1))*(-1);
        else
            return Integer.valueOf(s.substring(0));
    }
}