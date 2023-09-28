class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int result[][] = new int [arr1.length][arr2[0].length];
        for(int i =0;i<arr1.length;i++){
            for(int j=0;j<arr2[0].length;j++){
                result[i][j] = cal(arr1[i],arr2,j);
            }
        }
        return result;
    }
    public int cal (int [] arr1, int [][] arr2,int index){
        int sum = 0;
        for(int i=0;i<arr2.length;i++){
            sum+=arr1[i]*arr2[i][index];
        }
         return sum;
    }
}