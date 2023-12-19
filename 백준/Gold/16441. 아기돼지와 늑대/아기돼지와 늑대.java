import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;

    static int N, M;
    static char[][] map;
    static boolean[][] wolfVis;
    static Queue<int[]> wolfQ = new ArrayDeque<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        init();
        BFS();
        print();
    }

    static void init() throws IOException {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new char[N][M];
        wolfVis = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'W') {
                    wolfQ.offer(new int[]{i, j});
                    wolfVis[i][j] = true;
                }
            }
        }
    }

    static void BFS() {
        while (!wolfQ.isEmpty()) {
            int[] cur = wolfQ.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == '+') {
                    int[] movedCur = iceSliding(dir, nx, ny);
                    nx = movedCur[0];
                    ny = movedCur[1];
                }
                if (map[nx][ny] == '#' || wolfVis[nx][ny]) continue;

                wolfQ.offer(new int[]{nx, ny});
                wolfVis[nx][ny] = true;
            }
        }
    }

    static int[] iceSliding(int dir, int x, int y) {
        while (map[x][y] == '+') {
            x = x + dx[dir];
            y = y + dy[dir];
        }
        if (map[x][y] == '.' || map[x][y] == 'W')
            return new int[]{x, y};
        return new int[]{x - dx[dir], y - dy[dir]};
    }

    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '.' && !wolfVis[i][j]) sb.append("P");
                else sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}