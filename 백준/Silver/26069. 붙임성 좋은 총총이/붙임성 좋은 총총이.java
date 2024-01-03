import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        map.put("ChongChong", 0);
        while(N-->0){
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            if(map.containsKey(str1)){
                map.put(str2,0);
            }
            else if(map.containsKey(str2)){
                map.put(str1, 0);
            }
        }
        System.out.println(map.size());
    }
}