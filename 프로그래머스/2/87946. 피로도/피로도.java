import java.util.*;
class Solution {
    static boolean [] visited;
    static int count = 0;
    private void dfs(int current,int[][] dungeons, int d){
        if(d>count)
            count = d;
        for(int i =0;i<dungeons.length;i++){
            if(!visited[i]){
                if(current>=dungeons[i][0]){
                    visited[i] = true;
                    dfs(current-dungeons[i][1],dungeons,d+1);
                    visited[i] = false;
                }
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        int l = dungeons.length;
        visited = new boolean[l];
        dfs(k,dungeons,0);
        return count;
    }
}