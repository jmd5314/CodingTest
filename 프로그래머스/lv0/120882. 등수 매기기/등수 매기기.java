import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        int result [] = new int[score.length];
        List <Integer> scorelist = new ArrayList<>();
        for(int [] t:score){
            scorelist.add(t[0]+t[1]);
        }
        scorelist.sort(Comparator.reverseOrder());
        for(int i =0;i<result.length;i++){
            result[i]=scorelist.indexOf(score[i][0]+score[i][1])+1;
        }
        return result;
    }
}