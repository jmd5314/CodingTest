import java.util.*;
class Solution {
    static int x;
    static int y;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    static boolean [][] check;
    public int solution(int[][] maps) {
        x = maps.length - 1;
        y = maps[0].length - 1;
        check = new boolean [x+1][y+1];
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        check[0][0] = true;
        while(!q.isEmpty()){
            int [] now = q.poll();
            int now_x = now[0];
            int now_y = now[1];
            int now_d = now[2];
            if(now_x == x&&now_y == y){
                return now_d;
            }
            for(int i = 0;i<4;i++){
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                if(next_x>=0&&next_y>=0&&next_x<=x&&next_y<=y&&maps[next_x][next_y]==1&&!check[next_x][next_y]){
                    q.add(new int []{next_x,next_y,now_d+1});
                    check[next_x][next_y] = true;
                }
            }
        }
        return -1;
    }
}