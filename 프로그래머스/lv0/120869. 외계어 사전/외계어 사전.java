import java.util.*;
class Solution {
    public int solution(String[] spell, String[] dic) {
        List<String> list = new ArrayList <>(Arrays.asList(dic)); 
        int count = 0;
        int result = 2;
        for(int i=0;i<dic.length;i++){
            for(int j=0;j<spell.length;j++){
                if(list.get(i).contains(spell[j]))
                    count++;
            }
            if(count==spell.length){
                result=1;
                break;
            }
            else
                count=0;
                
        }
        return result;
    }
}