import java.util.*;
class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static int l;
    private int bfs(int c, int n1, int n2){
        int count = 1;
        boolean [] visited = new boolean[l+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(c);
        visited[c] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i);
                if(Math.min(now,next)==n1 && Math.max(now,next) == n2)
                    continue;
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
        return count;
    }
    public int solution(int n, int[][] wires) {
        for(int i =0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        int answer = n;
        l = n;
        for(int [] w : wires){
            graph.get(w[0]).add(w[1]);
            graph.get(w[1]).add(w[0]);
        }
        for(int i =0;i<wires.length;i++){
            int c1 = bfs(wires[i][0],wires[i][0],wires[i][1]);
            int c2 = bfs(wires[i][1],wires[i][0],wires[i][1]);
            answer = Math.min(answer,Math.abs(c1-c2));
        }
        return answer;
    }
}