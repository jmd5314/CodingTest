import java.util.*;
class Solution {
    public String[] solution(String my_str, int n) {
        List <String> list = new ArrayList<>();
        int i = 0;
        while(i<my_str.length()){
            if(i+n>my_str.length()){
                list.add(my_str.substring(i,my_str.length()));
                break;
            }
            list.add(my_str.substring(i,i+n));
            i+=n;
        }
        String answer [] = list.toArray(new String [list.size()]);
        return answer;
    }
}