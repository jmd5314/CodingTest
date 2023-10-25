import java.util.Scanner;

public class Main {
    private static int search(int arr[],int N,int M){
        int result = 0;
        for(int i=0;i<N-2;i++){
            for(int j =i+1;j<N-1;j++){
                for(int k = j+1;k<N;k++){
                    int sum = arr[i]+arr[j]+arr[k];
                    if(sum==M){
                        return sum;
                    }
                    if(sum<M&&result<sum)
                        result = sum;
                }
            }
        }
        return result;
    }
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int arr[] = new int [N];
        int result = 0;
        for(int i =0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(search(arr,N,M));
    }
}