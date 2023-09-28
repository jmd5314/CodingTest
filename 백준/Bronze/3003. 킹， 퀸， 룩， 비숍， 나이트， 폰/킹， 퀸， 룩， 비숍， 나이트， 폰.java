import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int chess[] = {1, 1, 2, 2, 2, 8};
        int w_chess[] = new int[6];
        int b_chess[] = new int[6];
        for(int i=0;i<6;i++){
            w_chess[i] = sc.nextInt();
            b_chess[i] = chess[i]-w_chess[i];
            System.out.print(b_chess[i]+" ");
        }
}
}