class Solution {
    boolean solution(String s) {
        int count = 0;
        for(String t:s.split("")){
            if(t.equals("p")||t.equals("P"))
                count++;
            else if(t.equals("y")||t.equals("Y"))
                count--;
        }
        return (count==0)?true:false;
    }
}