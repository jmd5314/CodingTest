import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        int five_num = N/5;
        int three_num =(N-(5*five_num))/3;
        while(five_num*5+three_num*3!=N){
            five_num-=1;
            three_num = (N-(5*five_num))/3;
            if(five_num<0)
                break;
        }
        if(five_num == -1)
            System.out.println(-1);
        else{
            System.out.println(five_num+three_num);
        }
    }
}