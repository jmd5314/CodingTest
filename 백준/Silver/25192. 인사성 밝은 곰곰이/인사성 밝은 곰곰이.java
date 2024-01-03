import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        while(N-->0){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("ENTER")){
                map.clear();
            }
            else if(!map.containsKey(str)){
                map.put(str,1);
                count++;
            }
        }
        System.out.println(count);
    }
}