import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        double n = 0.0;
        double sum = 0.0;
        Scanner sc = new Scanner(System.in);
        String grade[] = {"A+","A0","B+","B0","C+","C0","D+","D0","F","P"};
        for(int i =0;i<20;i++){
            String s = sc.nextLine();
            String ss[] = s.split(" ");
            for(int j=0;j<grade.length-2;j++){
                if(grade[j].equals(ss[2])){
                    sum+=Double.parseDouble(ss[1])*(4.5-(j*0.5));
                    break;
                }
            }
            if(!ss[2].equals("P"))
                n+=Double.parseDouble(ss[1]);
        }
        System.out.println(sum/n);
    }
}