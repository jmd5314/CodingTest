class Solution {
    public int solution(int[][] dots) {
        if(slope(dots[0],dots[1])==slope(dots[2],dots[3]))
            return 1;
        else if (slope(dots[0],dots[2])==slope(dots[1],dots[3]))
            return 1;
        else if (slope(dots[0],dots[3])==slope(dots[1],dots[2]))
            return 1;
        else
            return 0;
    }
    public double slope (int[] dot1, int[] dot2){
        return (double)(dot2[1]-dot1[1])/(dot2[0]-dot1[0]);
    }
}