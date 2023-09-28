import java.util.*;
class Solution {
    public String solution(String letter) {
        String result="";
        String str[]={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String morse[]=letter.split(" ");
        for(int i =0;i<morse.length;i++){
            result+= (char)('a'+Arrays.asList(str).indexOf(morse[i]));
        }
        return result;
    }
}