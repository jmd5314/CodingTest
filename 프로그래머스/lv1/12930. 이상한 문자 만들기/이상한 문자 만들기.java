class Solution {
    public String solution(String s) {
        StringBuilder str = new StringBuilder();
        char ch [] = s.toCharArray();
        int count = 0;
        for(char c:ch){
            if(Character.isSpaceChar(c)){
                count=0;
                str.append(c);
                continue;
            }
            if(count%2==0)
                str.append(Character.toUpperCase(c));
            else
                str.append(Character.toLowerCase(c));
            count++;
        }
        return str.toString();
    }
}