import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int [] result = new int[commands.length];
        for(int x = 0; x < commands.length; x++){
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];
            int [] arr = new int[j-i+1];
            for(int y = 0; y< arr.length;y++){
                arr[y] = array[i-1+y];
            }
            Arrays.sort(arr);
            result[x] = arr[k-1];
        }
        return result;
    }
}