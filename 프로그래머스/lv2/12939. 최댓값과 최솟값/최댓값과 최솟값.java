class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String str[] = s.split(" ");
        for(String st : str){
            if(Integer.valueOf(st)>=max)
                max = Integer.valueOf(st);
            if(Integer.valueOf(st)<=min)
                min = Integer.valueOf(st);
        }
        String result = String.valueOf(min)+" "+String.valueOf(max);
        return result;
    }
}