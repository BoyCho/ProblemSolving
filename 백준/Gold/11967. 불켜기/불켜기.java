import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;

    static int N, M, cnt = 1;
    static int[][] map;
    static boolean[][] vis;

    static List<int[]>[][] switches;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        switches = new ArrayList[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                switches[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            switches[x][y].add(new int[]{a, b});
        }

        map = new int[N + 1][N + 1];
        map[1][1] = 1;

        while (lightBFS()) {}

        System.out.println(cnt);
    }

    static boolean lightBFS() {
        Queue<int[]> Q = new ArrayDeque<>();
        Q.offer(new int[]{1, 1});

        vis = new boolean[N + 1][N + 1];
        vis[1][1] = true;

        boolean switchOn = false;

        while (!Q.isEmpty()) {
            int[] cur = Q.poll();

            for (int[] light : switches[cur[0]][cur[1]]) {
                if (map[light[0]][light[1]] == 0) {
                    map[light[0]][light[1]] = 1;
                    switchOn = true;
                    cnt++;
                }
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
                if (map[nx][ny] == 0 || vis[nx][ny]) continue;

                Q.offer(new int[]{nx, ny});
                vis[nx][ny] = true;
            }
        }
        return switchOn;
    }
}