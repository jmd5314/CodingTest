class Solution {
    public int solution(int[] array) {
        int result = 0;
        String str ="";
        for(int i : array)
            str+=i+"";
        for(String j :str.split("") )
            if(j.equals("7"))
                result++;
        return result;
    }
}