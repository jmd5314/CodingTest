class Solution {
    public int solution(int n) {
        int icount = 0;
        for(int i =1;i<=n;i++){
            int tcount = 0;
            for(int j=1;j<=i;j++){
                if(i%j==0)
                    tcount++;
            }
            if(tcount>=3){
                icount++;
            }
        }
        return icount;
    }
}