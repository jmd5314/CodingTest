class Solution {
    public String solution(String rsp) {
        String result="";
        for(char ch:rsp.toCharArray()){
            if(ch=='2')
                result+="0";
            else if(ch=='0')
                result+="5";
            else
                result+="2";
        }
        return result;
    }
}