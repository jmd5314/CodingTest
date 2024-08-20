import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int a, b, c, d;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void bfs() {
        Queue<int[]> fireQueue = new LinkedList<>();
        Queue<int[]> personQueue = new LinkedList<>();

        // 불과 사람의 초기 위치를 큐에 추가
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'F') {
                    fireQueue.add(new int[]{i, j});
                } else if (map[i][j] == 'J') {
                    personQueue.add(new int[]{i, j, 1}); // 초기 사람 위치와 이동 거리
                }
            }
        }

        // BFS 시작 (불과 사람을 동시에 처리)
        while (!personQueue.isEmpty()) {
            // 먼저 불의 BFS를 한 턴 수행
            int fireSize = fireQueue.size();
            for (int f = 0; f < fireSize; f++) {
                int[] fire = fireQueue.poll();
                int fx = fire[0];
                int fy = fire[1];

                for (int i = 0; i < 4; i++) {
                    int nfx = fx + dx[i];
                    int nfy = fy + dy[i];

                    if (nfx >= 0 && nfy >= 0 && nfx < R && nfy < C) {
                        if (map[nfx][nfy] == '.') {  // 불이 퍼질 수 있는 곳
                            map[nfx][nfy] = 'F';
                            fireQueue.add(new int[]{nfx, nfy});
                        }
                    }
                }
            }

            // 그 다음 사람의 BFS를 한 턴 수행
            int personSize = personQueue.size();
            for (int p = 0; p < personSize; p++) {
                int[] person = personQueue.poll();
                int px = person[0];
                int py = person[1];
                int dist = person[2];

                for (int i = 0; i < 4; i++) {
                    int npx = px + dx[i];
                    int npy = py + dy[i];

                    if (npx >= 0 && npy >= 0 && npx < R && npy < C) {
                        if (map[npx][npy] == '.') {  // 빈 공간으로만 이동
                            map[npx][npy] = 'J';
                            personQueue.add(new int[]{npx, npy, dist + 1});
                        }
                    } else {
                        System.out.println(dist);
                        return;
                    }
                }
            }
        }

        // 탈출 불가능한 경우
        System.out.println("IMPOSSIBLE");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'J') {
                    a = i;
                    b = j;
                } else if (map[i][j] == 'F') {
                    c = i;
                    d = j;
                }
            }
        }
        bfs();
    }
}