class Solution {
    public int solution(String my_string) {
        int sum = 0;
        String str = my_string.replaceAll("[^0-9]","");
        for(int i=0;i<str.length();i++){
            sum+=Integer.parseInt(str.substring(i,i+1));
        }
        return sum;     
    }
}