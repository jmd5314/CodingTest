import java.util.*;
class Solution {
    private int compress(String source, int length){
        StringBuilder builder = new StringBuilder();
        String last = "";
        int count = 0;
        for(String token:split(source,length)){
            if(token.equals(last))
                count++;
            else{
                if(count>1)
                    builder.append(count);
                builder.append(last);
                last = token;
                count = 1;
            }
        }
        if(count>1) builder.append(count);
        builder.append(last);
        return builder.length();
    }
    private List<String> split(String source, int length){
        List<String>tokens = new ArrayList<>();
        for(int start =0;start<source.length();start+=length){
            int end = start+length;
            if(end>source.length())
                end = source.length();
            tokens.add(source.substring(start,end));
        }
        return tokens;
    }
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=s.length();i++){
            int compressed = compress(s,i);
            if(compressed<min)
                min = compressed;
        }
        return min;
    }
}