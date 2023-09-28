class Solution {
    public int[] solution(int n) {
        int index = 0;
        int x = 0;
        if(n%2==0)
            x = n/2;
        else
            x = n/2+1;
        int arr[] = new int [x];
        for(int i =1;i<=n;i++){
            if(i%2==1){
                arr[index]=i;
                index++;
            }
                
        }
          return arr;   
        }
    }
