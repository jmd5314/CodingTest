import java.util.*;
class Solution {
    static char [] alpha = {'A','E','I','O','U'};
    static List<String> list = new ArrayList<>();
    private void generateWord(String current, int l){
        if(current.length() == l){
            list.add(current);
            return;
        }
        for(int i =0;i<5;i++){
            generateWord(current+alpha[i],l);
        }
    }
    
    public int solution(String word) {
        for(int i = 1;i <= 5;i++){
            generateWord("",i);        }
          Collections.sort(list);
    for(int i =0;i<list.size();i++){
        if(list.get(i).equals(word))
            return i+1;
    }
        return -1;
    }
}