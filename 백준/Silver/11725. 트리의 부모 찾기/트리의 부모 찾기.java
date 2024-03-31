import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for(int i =0;i<=N;i++){
            tree.add(new ArrayList<>());
        }
        for(int i =0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        boolean[] check = new boolean[N + 1];
        int[] parent = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        check[1] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for(int i=0;i<tree.get(now).size();i++){
                int next = tree.get(now).get(i);
                if(!check[next]){
                    check[next] = true;
                    q.add(next);
                    parent[next] = now;
                }
            }
        }
        for(int i =2;i<=N;i++){
            System.out.println(parent[i]);
        }
    }
}