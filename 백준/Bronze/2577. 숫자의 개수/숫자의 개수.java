import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count[] = new int[10];
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int sum = A*B*C;
        while (sum!=0){
            int index = sum%10;
            count[index]++;
            sum/=10;
        }
        for(int i =0;i<=9;i++){
            System.out.println(count[i]);
        }
    }
}