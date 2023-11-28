import java.util.*;
class Solution {
    private static char toJaden(char c){
        if(Character.isLetter(c)){
            return Character.toUpperCase(c);
        }
        else
            return c;
    }
    public String solution(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s," ",true);
        while(st.hasMoreTokens()){
            String str = st.nextToken();
            sb.append(toJaden(str.charAt(0)));
            sb.append(str.substring(1));
        }
        String result = sb.toString();
        return result;
    }
}