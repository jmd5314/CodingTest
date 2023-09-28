import java.util.Arrays;
class Solution {
    public int[] solution(int n) {
        int index = 0;
        int count = 0;
        for(int i =1;i<=n;i++){
            if(n%i==0){
                count++;
            }
        }
        int arr [] = new int[count];
        for(int j=1;j<=n;j++){
            if(n%j==0){
                arr[index]=j;
                index++;
            }
        }
        return arr;
    }
}