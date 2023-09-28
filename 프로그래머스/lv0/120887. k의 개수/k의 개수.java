class Solution {
    public int solution(int i, int j, int k) {
        String str = "";
        for(int x=i;x<=j;x++){
            str+=x+"";
        }
        return str.length()-str.replace(k+"","").length();
    
}
}