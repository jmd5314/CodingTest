class Solution {
    public String solution(String cipher, int code) {
        String result="";
        int index = 1;
        for(int i =1;code*i-1<cipher.length();i++){
            result+=cipher.substring(code*i-1,code*i);
        }
        return result;
    }
}