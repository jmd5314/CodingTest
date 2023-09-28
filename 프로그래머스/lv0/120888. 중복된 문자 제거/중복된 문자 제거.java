import java.util.*;
class Solution {
    public String solution(String my_string) {
        String str [] = my_string.split("");
        Set<String> set = new LinkedHashSet <String>(Arrays.asList(str));
        return String.join("",set);
}
}