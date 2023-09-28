class Solution {
    private char push(char c, int n){
        if(!Character.isAlphabetic(c))
            return c;
        int offset = Character.isUpperCase(c)?'A':'a';
        int position = c-offset;
        position = (position+n)%('Z'-'A'+1);
        return (char)(offset+position);
    }
    public String solution(String s, int n) {
        StringBuilder str = new StringBuilder();
        char ch[] = s.toCharArray();
        for(char c : ch){
            str.append(push(c,n));
        }
        return str.toString();
    }
        
}
