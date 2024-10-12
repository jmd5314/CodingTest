import java.util.*;
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] check;
    static int ni, nj, si, sj, ei, ej;
    static int result = -1;

    public int solution(String[] board) {
        ni = board.length;
        nj = board[0].length();
        check = new boolean[ni][nj];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    si = i;
                    sj = j;
                }
                if (board[i].charAt(j) == 'G') {
                    ei = i;
                    ej = j;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        check[si][sj] = true;
        q.add(new int[]{si, sj, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int c = now[2];
            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;
                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    // 장애물 만나면 멈춤
                    if (nx < 0 || ny < 0 || nx >= ni || ny >= nj||board[nx].charAt(ny) == 'D') {
                        nx -= dx[i];
                        ny -= dy[i];

                        if (nx == ei && ny == ej) {
                            result = c + 1;
                            return result;
                        }

                        if (!check[nx][ny]) {
                            check[nx][ny] = true;
                            q.add(new int[]{nx, ny, c + 1});
                        }
                        break;
                    }
                }
            }
        }
        return result;
    }
}