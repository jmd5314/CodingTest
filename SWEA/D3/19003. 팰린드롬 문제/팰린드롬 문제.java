
import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
    static boolean isPal(String s){
        char [] ch = s.toCharArray();
        for(int i =0;i<ch.length;i++){
        	if(ch[i]!=ch[ch.length-1-i])
                return false;
        }
        return true;
    }
    static boolean isPal(String s,String t){
        String st = s+t;
        return isPal(st);
    }
	public static void main(String args[]) throws Exception
	{
		 
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringBuilder sb = new StringBuilder();
            int count = 0;
            int middle = 0;
            int N = sc.nextInt();
            int M = sc.nextInt();
            String [] str = new String [N];
            boolean [] check = new boolean[N];
            for(int i = 0;i<N;i++){
            	str[i] = sc.next();
            }
            for(int i =0;i<N;i++){
            	for(int j = i+1;j<N;j++){
                	if(isPal(str[i],str[j])){
                        count+=2*M;
                        check[i] = true;
                        check[j] = true;
                        break;
                    }
                }
                if(!check[i]&&isPal(str[i])){
                    middle = str[i].length();
                }
            }
            sb.append("#"+test_case+" "+(count+middle));
            System.out.println(sb);
		}
	}
}