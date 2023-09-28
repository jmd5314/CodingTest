class Solution {
    public String solution(String polynomial) {
        String str [] = polynomial.split(" ");
        String result = "";
        int num = 0;
        int xnum = 0;
        for(int i =0;i<str.length;i+=2){
            if(str[i].contains("x")){
                if(str[i].length()==1){
                    xnum+=1;
                }
                else{
                    xnum+=Integer.valueOf(str[i].substring(0,str[i].length()-1));
                }
            }
            else {
                num+=Integer.valueOf(str[i]);
            }
        }
        if(xnum==0){
            if(num==0)
                result = "0";
            else
                result = String.valueOf(num);
        }
        else if(xnum==1){
            if(num==0)
                result = "x";
            else
                 result = "x + "+String.valueOf(num);
            }
        else{
            if(num==0)
                result = String.valueOf(xnum)+"x";
            else
                result = String.valueOf(xnum)+"x + "+String.valueOf(num);
        }
        return result;
}
}