import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> playCount = new HashMap<>();
        HashMap<String,Map<Integer, Integer>> songInfo = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++){
            playCount.put(genres[i],playCount.getOrDefault(genres[i],0)+plays[i]);
            Map<Integer,Integer> map = songInfo.getOrDefault(genres[i],new HashMap<Integer,Integer>());
            map.put(i,plays[i]);
            songInfo.put(genres[i],map);
            
            }
            
            List<String> keySet = new ArrayList<>(playCount.keySet());
            Collections.sort(keySet, (o1,o2) ->{
                return playCount.get(o2) - playCount.get(o1);
            });
            
            for(String k : keySet){
                Map<Integer, Integer> info = songInfo.get(k);
                List<Integer> list = new ArrayList<>(info.keySet()); 
                Collections.sort(list, (o1,o2)->{
                    return info.get(o2) - info.get(o1);
                });
                answer.add(list.get(0));
                if(list.size()>=2){
                    answer.add(list.get(1));
                }
            }
        int [] arr = new int[answer.size()];
        for(int i = 0; i<answer.size();i++){
            arr[i] = answer.get(i);
        }
        return arr;
    }
}