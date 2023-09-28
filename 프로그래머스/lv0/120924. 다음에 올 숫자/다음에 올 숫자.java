class Solution {
    public int solution(int[] common) {
        int gnum = 0;
        int anum = common[1]-common[0];
        if(common[0]!=0)
            gnum = common[1]/common[0];
        if(common[2]-common[1]==anum)
            return common[common.length-1]+anum;
        else
            return common[common.length-1]*gnum;
    }
}