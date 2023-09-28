import java.util.*;
class Solution {
    public int solution(int[] array) {
        int max = 0;
        int result = 0;
        Set set = new HashSet();
        for(int i=0;i<array.length;i++){
            set.add(array[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        int count [] = new int[list.size()];
        for(int i=0;i<array.length;i++){
            count[list.indexOf(array[i])]++;
        }
          for(int i = 0;i<count.length;i++){
            if(count[i]>max){
                max = count[i];
                result = list.get(i);
            }
            else if(count[i]==max)
                result = -1;
        }
        return result;
    }
}