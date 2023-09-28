class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String result = "fail";
        for(int i=0;i<db.length;i++){
            if(id_pw[0].equals(db[i][0])){
                if(id_pw[1].equals(db[i][1])){
                    result="login";
                    break;
                }
                else
                    result="wrong pw";
            }
        }
        return result;
    }
}