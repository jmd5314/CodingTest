import java.util.Scanner;
public class Main {
    public static void main(String[] args)  {
        int min= Integer.MAX_VALUE;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String str[] = new String[N];
        for(int i =0;i<N;i++){
            str[i] = sc.next();
        }
        for(int i =0;i<N-7;i++){
            for(int j =0;j<M-7;j++){
                for(int k = 0;k<2;k++){
                    char start = k == 0 ? 'W' : 'B';
                    int count = 0;
                    for(int n =i;n<i+8;n++){
                        for(int m = j;m<j+8;m++){
                            if(start !=str[n].charAt(m))
                                count++;
                            start = start == 'W' ? 'B' : 'W';
                        }
                        start = start == 'W' ? 'B' : 'W';
                    }
                    if(count<min)
                        min = count;
                }
            }
        }
        System.out.println(min);
    }
}