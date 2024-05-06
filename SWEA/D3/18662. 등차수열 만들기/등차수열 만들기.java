
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringBuilder sb = new StringBuilder();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            double x = Math.abs((double)(a+c)/2-b);
            String result = String.format("%.1f",x);
            sb.append("#"+test_case+" "+result);
            System.out.println(sb);
		}
	}
}