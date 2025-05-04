class Solution {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        
        for(int i = 0; i < sizes.length; i++){
            for(int j = 0;j<2;j++){
                // 세로가 가로보다 길다면 세로를 가로로 놓기
                if(sizes[i][0]<sizes[i][1]){
                    if(w < sizes[i][1]){
                        w = sizes[i][1];
                    }
                    if(h < sizes[i][0]){
                        h = sizes[i][0];
                    }
                }
                else{
                    if(w < sizes[i][0]){
                        w = sizes[i][0];
                    }
                    if(h < sizes[i][1]){
                        h = sizes[i][1];
                    }
                }
            }
        }
        return w*h;
    }
}