class Solution {
    public String solution(String my_string, int num1, int num2) {
        String result = "";
        char c[] = my_string.toCharArray();
        char tmp = c[num1];
        c[num1] = c[num2];
        c[num2] = tmp;
        result = new String(c);
        return result;
    }
}