import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //더하기가 있는 식들을 전부 괄호처리 하고 뺄셈을 처리 하면 최솟값이 나온다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        String[] subtraction = br.readLine().split("-");
        for(int i =0;i<subtraction.length;i++){
            int temp = 0;
            String[] addition = subtraction[i].split("\\+");
            for(int j=0;j<addition.length;j++){
                temp+=Integer.parseInt(addition[j]);
            }
            if(i==0){
                sum = temp;
            }
            else {
                sum-=temp;
            }
        }
        System.out.println(sum);
    }
}