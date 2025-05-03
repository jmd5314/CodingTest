import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> playCount = new HashMap<>();
        Map<String, Map<Integer, Integer>> music = new HashMap<>();
        for(int i =0;i < genres.length; i++){
            String g = genres[i];
            int p = plays[i];
            // 장르를 처음 저장한다면
            if(!playCount.containsKey(g)){
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i,p);
                playCount.put(g,p);
                music.put(g,map);
            }
            // 저장했던 장르라면
            else{
                playCount.put(g,playCount.get(g)+p);
                Map<Integer, Integer> map = music.get(g);
                map.put(i,p);
                music.put(g,map);
            }
        }
        List<String> keySet = new ArrayList<>(playCount.keySet());
        Collections.sort(keySet,(o1,o2)->{
          return playCount.get(o2) - playCount.get(o1);
        });
        for(String k : keySet){
            Map<Integer, Integer> map = music.get(k);
            List<Integer> musicNum = new ArrayList<>(map.keySet());
            Collections.sort(musicNum,(o1,o2)->{
               return map.get(o2) - map.get(o1);
            });
            for(int i = 0;i<musicNum.size();i++){
                answer.add(musicNum.get(i));
                if(i == 1)
                    break;
            }
        }
        int [] result = new int [answer.size()];
        for(int i = 0;i<result.length; i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}