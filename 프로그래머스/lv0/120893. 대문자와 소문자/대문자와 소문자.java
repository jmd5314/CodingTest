class Solution {
    public String solution(String my_string) {
        String result="";
        char arr[] = my_string.toCharArray();
        for(int i =0; i<my_string.length();i++){
            if(97<=arr[i]&&arr[i]<=122)
                result+=(char)(arr[i]-32);
            else if(65<=arr[i]&&arr[i]<=90)
                result+=(char)(arr[i]+32);
        }
        return result;
        
     }   
    }
