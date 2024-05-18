import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
			int [] box = new int[100];
			for(int i =0;i<100;i++) {
				box[i] = sc.nextInt();
			}
			for(int i =0;i<N;i++) {
				Arrays.sort(box);
				box[99]-=1;
				box[0] +=1;
			}
			Arrays.sort(box);
			System.out.println("#"+test_case+" "+(box[99]-box[0]));
		}
	}
}