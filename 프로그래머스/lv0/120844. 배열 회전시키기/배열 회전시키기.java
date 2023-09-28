class Solution {
    public int[] solution(int[] numbers, String direction) {
        int [] result= new int[numbers.length];
        if(direction.equals("left")){
            for(int i=0;i<numbers.length;i++){
                if(i==numbers.length-1)
                    result[i]=numbers[0];
                else
                    result[i]=numbers[i+1];
            }
        }
        else{
            for(int i=0;i<numbers.length;i++){
                if(i==0)
                    result[i]=numbers[numbers.length-1];
                else
                    result[i]=numbers[i-1];
        }
    }
        return result;
}
}