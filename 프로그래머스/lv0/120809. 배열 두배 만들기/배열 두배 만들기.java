class Solution {
    public int[] solution(int[] numbers) {
        int arr[] = new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            arr[i]=numbers[i]*2;
        }
        return arr;
    }
}