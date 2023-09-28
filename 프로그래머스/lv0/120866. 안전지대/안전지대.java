class Solution {
    public int solution(int[][] board) {
        int count = 0;
        //board와 같은 크기의 새로운 배열 정의
        int [][] bom = new int [board.length][board[0].length]; 
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]==1)
                    checkbom(i,j,bom);
            }
        }
        for(int i [] : bom){ //위험지역과 지뢰있는 곳을 제외하고 count -> 안전한 지역의 칸 수
            for(int j : i){
                if(j==0)
                    count++;
            }
        }
        return count;
    }
    // 지뢰 주위 위험지역과 지뢰가 있는 자리에 1을 저장해주는 함수
    static void checkbom(int x, int y, int[][]bom){
        int bomx = 0;
        int bomy = 0;
        int checkx[] = {-1,-1,-1,0,0,0,1,1,1};
        int checky[] = {-1,0,1,-1,0,1,-1,0,1};
        for(int i=0;i<9;i++){
            bomx = x+checkx[i];
            bomy = y+checky[i];
            if(bomx<bom.length&&bomy<bom[0].length){
                if(bomx>=0&&bomy>=0){
                    bom[bomx][bomy]=1;
                }
            }
        }
        
    }
}