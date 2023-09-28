class Solution {
    public int solution(int n) {
        String str = Integer.toString(n,3);
        StringBuilder builder = new StringBuilder(str);
        return Integer.parseInt(builder.reverse().toString(),3);  
    }
}