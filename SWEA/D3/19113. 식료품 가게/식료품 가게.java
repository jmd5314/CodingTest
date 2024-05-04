import java.util.*;
import java.io.FileInputStream;
class Solution
{
    static List<Integer> list = new ArrayList<>();
    static int [] answer;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringBuilder sb = new StringBuilder();
            int N = sc.nextInt();
            answer = new int [N];
            for(int i = 0;i<2*N;i++){
            	list.add(sc.nextInt());
            }
            int index = 0;
            for(int i =0;i<list.size();i++){
                if(list.get(i)%3==0&&list.contains((list.get(i)/3)*4)){
                    answer[index++] = list.get(i);
                    list.remove(new Integer((list.get(i)/3)*4));
                }
                else
                    continue;
            }
            sb.append("#"+test_case+" ");
            for(int i =0;i<N;i++){
            	sb.append(answer[i]).append(" ");
            }
            System.out.println(sb);
            list.clear();
        }
	}
}