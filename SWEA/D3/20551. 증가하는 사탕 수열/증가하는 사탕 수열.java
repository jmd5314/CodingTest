
import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
    static int [] candy;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int count = 0;
            candy = new int[3];
            for(int i = 0;i<3;i++){
            candy[i] = sc.nextInt();
            }
            if(candy[1]>=candy[2]){
            	count+=candy[1]-candy[2]+1;
                candy[1] = candy[2]-1;
            }
            if(candy[0]>=candy[1]){
            	count+=candy[0]-candy[1]+1;
                candy[0] = candy[1]-1;
            }
            if(candy[0]<=0||candy[1]<=0)
                count = -1;
            System.out.println("#"+test_case+" "+count);
		}
	}
}