import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        Integer[] num =  Arrays.stream(numbers)
            .boxed()
            .sorted((o1,o2)->{
                return Integer.parseInt(o2+""+o1) - Integer.parseInt(o1+""+o2);
            })
            .toArray(Integer[]::new);
        StringBuilder sb = new StringBuilder();
        if(num[0]==0) 
            return "0";
        for(int i : num){
            sb.append(i);
        }
        return sb.toString();
    }
}