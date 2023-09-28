import java.util.Arrays;
class Solution {
    public int[] solution(String my_string) {
        String str = my_string.replaceAll("[^0-9]","");
        int arr [] = new int[str.length()];
        for(int i =0;i<str.length();i++)
            arr[i]=Integer.valueOf(str.substring(i,i+1));
        Arrays.sort(arr);
        return arr;
}
}