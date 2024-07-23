 
import java.util.*;
import java.io.*;

 
class Solution
{
     static String str;
    static int count;
    public static void dfs(char c,int d){
        if(d==str.length()-1){
            return;
        }
        // 다음 수가 현재 수와 같은 경우 count 증가 없이 dfs
        if(str.charAt(d+1)==c)
            dfs(c, d + 1);
        // 다음 수가 다른 경우 count 증가
        else{
            if(c=='1'){
                dfs('0', d + 1);
            }
            else{
                dfs('1', d + 1);
            }
            count++;
        }
    }
	public static void main(String args[]) throws Exception
	{
        
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
            str = br.readLine();
            count = 0;
            // 1로 시작하는 경우 카운트
            if(str.charAt(0)=='1')
                count++;
            dfs(str.charAt(0), 0);
            System.out.println("#"+test_case+" "+count);
		}
	}
}