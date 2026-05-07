import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> map = new HashMap<>();
        for(String num : phone_book){
            map.put(num, true);
        }
        for(int i = 0; i < phone_book.length; i++){
            String s = phone_book[i];
            // 다 똑같은 경우가 존재하기 때문에 전체를 자르면 안됨
            for(int j = 0; j < s.length() - 1; j++){
                String prefix = s.substring(0,j + 1);
                if(map.containsKey(prefix)){
                    return false;
                }
            }
        }
        return true;
    }
}