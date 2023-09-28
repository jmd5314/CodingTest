import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = 2*N-1;
        int n = 1;
        int c = 1;
        for(int i =1;i<=S;i++){
                for(int j = 1;j<=(S-c)/2;j++)
                    System.out.print(" ");
                for(int k = 1;k<=c;k++)
                    System.out.print("*");
            System.out.println();
            if(n<S)
                c+=2;
            else
                c+=-2;
            n+=2;
        }
}
}