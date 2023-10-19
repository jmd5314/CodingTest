import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int tri[] = new int[3];
        for(int i=0;i<3;i++){
            tri[i] = sc.nextInt();
        }
        Arrays.sort(tri);
        if(tri[0]+tri[1]>tri[2])
            System.out.println(tri[0]+tri[1]+tri[2]);
        else
            System.out.println(2*tri[0]+2*tri[1]-1);
    }
}