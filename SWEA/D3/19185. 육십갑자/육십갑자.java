import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int Test;
		Test=sc.nextInt();
		for(int test_case = 1; test_case <= Test; test_case++)
		{
            StringBuilder sb = new StringBuilder();
            sb.append("#"+test_case+" ");
            int N = sc.nextInt();
            int M = sc.nextInt();
            String [] S = new String [N];
            String [] T = new String [M];
            for(int i =0;i<N;i++){
            	S[i] = sc.next();
            }
            for(int i = 0;i<M;i++){
            	T[i] = sc.next();
            }
            int Q = sc.nextInt();
            for(int i =0;i<Q;i++){
            	int Y = sc.nextInt();
                int index_s = Y%N-1;
                if(index_s == -1)
                    index_s = N-1;
                int index_t = Y%M-1;
                if(index_t == -1)
                    index_t = M-1;
                sb.append(S[index_s]).append(T[index_t]).append(" ");
            }
            System.out.println(sb);
		}
	}
}