import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    private static void isDivisor(int n){
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 1;i<n;i++){
            if(n%i==0){
                list.add(i);
                sum+=i;
            }
        }
        if(sum==n){
            System.out.print(n+" = ");
            for(int i = 0;i<list.size();i++){
                if(i<list.size()-1)
                    System.out.print(list.get(i)+" + ");
                else
                    System.out.println(list.get(i));
            }
        }
        else
            System.out.println(n+" is NOT perfect.");
    }
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n==-1)
                break;
            isDivisor(n);
        }
    }
}