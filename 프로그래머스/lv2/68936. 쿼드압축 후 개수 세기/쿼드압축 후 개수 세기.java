class Solution {
    private static class Count{
        public final int zero;
        public final int one;
        
        public Count(int zero, int one){
            this.zero = zero;
            this.one = one;
        }
        public Count add(Count other){
            return new Count(zero+other.zero,one+other.one);
        }
    }
     private Count count(int X,int Y,int size,int[][]arr){
            int h =size/2;
            for(int x = X;x<X+size;x++){
                for(int y=Y;y<Y+size;y++){
                    if(arr[y][x]!=arr[Y][X]){
                        return count(X,Y,h,arr)
                            .add(count(X+h,Y,h,arr))
                            .add(count(X,Y+h,h,arr))
                            .add(count(X+h,Y+h,h,arr));
                    }
                }
            }
         if(arr[Y][X]==1){
             return new Count(0,1);
         }
         return new Count(1,0);
        }
    public int[] solution(int[][] arr) {
        Count count = count(0,0,arr.length,arr);
        return new int[] {count.zero,count.one};
    }
}