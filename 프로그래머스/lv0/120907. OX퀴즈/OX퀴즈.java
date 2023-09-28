class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String [quiz.length];
        for(int i =0;i<quiz.length;i++){
            String str [] = quiz[i].split(" ");
            if(str[1].equals("+")){
                answer[i] = Integer.valueOf(str[0])+Integer.valueOf(str[2])==Integer.valueOf(str[4])?"O":"X";
            }
            else{
                answer[i] = Integer.valueOf(str[0])-Integer.valueOf(str[2])==Integer.valueOf(str[4])?"O":"X";
                
            }
        }
        return answer;
    }
}