class Solution {
    public String solution(String my_string) {
        StringBuffer str= new StringBuffer(my_string);
        String result = str.reverse().toString();
       
        return result;
    }
}