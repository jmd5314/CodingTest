class Solution {
    public int solution(int num, int k) {
        String nstr = String.valueOf(num);
        String kstr = String.valueOf(k);
        int result = nstr.indexOf(kstr);
        if(result!=-1)
            result+=1;
        return result;
    }
}