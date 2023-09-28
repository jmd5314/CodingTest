class Solution {
    public int[][] solution(int[] num_list, int n) {
        int in = num_list.length/n;
        int index = 0;
        int result [][] = new int[in][n];
        for(int i =0;i<in;i++)
            for(int j = 0;j<n;j++){
                result[i][j]=num_list[index];
                index++;
            }
        return result;
}
}