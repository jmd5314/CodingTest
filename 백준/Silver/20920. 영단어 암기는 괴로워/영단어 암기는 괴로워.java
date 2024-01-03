import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.length() >= M) {
                map.put(str,map.getOrDefault(str,0)+1);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1)!=map.get(o2))
                    return map.get(o2)-map.get(o1); //내림차순 정렬
                if(o1.length()!=o2.length())
                    return o2.length() - o1.length();
                return o1.compareTo(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s:list){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}