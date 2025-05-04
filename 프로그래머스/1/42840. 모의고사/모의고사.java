import java.util.*;
class Solution {
    static final int [] N1 = {1,2,3,4,5};
    static final int [] N2 = {2,1,2,3,2,4,2,5};
    static final int [] N3 = {3,3,1,1,2,2,4,4,5,5};
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int [] count = new int[3];
        int l = answers.length;
        int n1 = N1.length;
        int n2 = N2.length;
        int n3 = N3.length;
        
        for(int i = 0; i < l;i++){
            int a = answers[i];
            for(int j = 1; j<=3;j++){
                if(a==N1[i%n1]){
                    count[0]++;
                }
                if(a==N2[i%n2]){
                    count[1]++;
                }
                if(a==N3[i%n3]){
                    count[2]++;
                }
            }
        }
        int max = 0;
        
        for(int i =0;i<3;i++){
            if(count[i]>max)
                max = count[i];
        }
        
        for(int i =0;i<3;i++){
            if(count[i]==max)
                list.add(i+1);
        }
        return list.stream()
            .sorted((o1,o2)->(o1-o2))
            .mapToInt(Integer::intValue)
            .toArray();
    }
}