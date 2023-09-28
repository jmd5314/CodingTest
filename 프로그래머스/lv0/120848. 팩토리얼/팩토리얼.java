
class Solution {    
   public int solution(int n) {
       int i = 1;
       int sum =1;
   while(true){
       if(sum<=n){
           sum*=i+1;
           i++;
       }
       else{
           i--;
           break;
       }
   }
   return i;
   }  
}