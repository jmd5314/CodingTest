class Solution {
    public String solution(int age) {
        String result = "";
        String str = String.valueOf(age);
        String alpha[]={"a","b","c","d","e","f","g","h","i","j"};
        for(int i=0;i<str.length();i++)
                result+=alpha[Integer.valueOf(str.substring(i,i+1))];
        
        return result;
    }
}