import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i =0;i<N;i++){
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
            max = Math.max(max, map.get(name));
        }
        List<String> list = new ArrayList<>(map.keySet());
        // 사전 순 정렬
        Collections.sort(list);
        for(String s:list){
            if (map.get(s) == max) {
                System.out.println(s);
                break;
            }
        }
    }
}