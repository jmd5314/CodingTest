class Solution {
    public long solution(String numbers) {
        int i =0;
        String alpha[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(String a:alpha)
        {
            numbers = numbers.replace(a,String.valueOf(i));
            i++;
        }
        return Long.parseLong(numbers);
    }
}