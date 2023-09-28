class Solution {
    public int[] solution(String s) {
        int loop = 0;
        int removed = 0;
        while(!s.equals("1")){
            for(String str : s.split("")){
                if(str.equals("0"))
                    removed++;
            }
            String t = s.replace("0","");
            s=Integer.toString(t.length(),2);
            loop++;
        }
        int result [] = {loop,removed};
        return result;
    }
}