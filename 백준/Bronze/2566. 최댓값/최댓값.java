import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        int max = 0;
        int x= 0;
        int y =0;
        Scanner sc = new Scanner(System.in);
        int num[][] = new int[9][9];
        for(int i =0;i<9;i++){
            for(int j=0;j<9;j++){
                num[i][j] = sc.nextInt();
                if(num[i][j]>=max){
                    max = num[i][j];
                    x=i+1;
                    y=j+1;
                }
            }
        }
        System.out.println(max);
        System.out.println(x+" "+y);
    }
}
