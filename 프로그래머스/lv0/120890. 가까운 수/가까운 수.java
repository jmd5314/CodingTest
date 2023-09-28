class Solution {
    public int solution(int[] array, int n) {
        int min = Math.abs(array[0]-n);
        int result = array[0];
        for(int i =1;i<array.length;i++){
            if(min>Math.abs(array[i]-n)){
                min = Math.abs(array[i]-n);
                result = array[i];
            }
            else if (min==Math.abs(array[i]-n))
                result = Math.min(result,array[i]);
        }
        return result;
    }
}