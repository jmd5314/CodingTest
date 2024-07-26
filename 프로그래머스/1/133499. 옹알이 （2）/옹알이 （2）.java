import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        List<String> valid = Arrays.asList("aya", "ye", "woo", "ma");
        return (int)Arrays.stream(babbling)
            .filter(s->{
                for(String v: valid){
                    if(s.contains(v+v))
                        return false;
                }
                String ms = s;
                for(String v:valid){
                    ms = ms.replaceAll(v," ");
                }
               return ms.trim().isEmpty()?true:false;
            })
            .count();
    }
}