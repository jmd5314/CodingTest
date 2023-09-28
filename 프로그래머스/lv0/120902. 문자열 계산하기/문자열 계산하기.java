class Solution {
    public int solution(String my_string) {
        String str[] = my_string.split(" ");
        int sum =0;
        for(int i = 1;i<str.length-1;i=i+2){
            if(i==1){
                if(str[i].equals("+"))
                    sum=Integer.valueOf(str[0])+Integer.valueOf(str[2]);
                else
                    sum=Integer.valueOf(str[0])-Integer.valueOf(str[2]);
            }
            else{
            if(str[i].equals("+"))
                sum+=Integer.valueOf(str[i+1]);
            else
                sum-=Integer.valueOf(str[i+1]);
            }
        }
        return sum;
    }
}