class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int result [] = {0,0};
        int x = board[0]/2;
        int y = board[1]/2;
        for(int i = 0;i<keyinput.length;i++){
            if(keyinput[i].equals("up")){
                if(result[1]<y)
                    result[1]+=1;
            }
            else if(keyinput[i].equals("down")){
                if(result[1]>-y)
                    result[1]-=1;
            }
            else if(keyinput[i].equals("left")){
                if(result[0]>-x)
                    result[0]-=1;
            }
            else{
                if(result[0]<x)
                    result[0]+=1;
            }
            }
         return result;
        }
}