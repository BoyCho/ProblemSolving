import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            stk = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());
            int K = Integer.parseInt(stk.nextToken());

            int[][] map = new int[N][M];
            boolean[][] vis = new boolean[N][M];

            while (K-- > 0) {
                stk = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());

                map[x][y] = 1;
            }

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (vis[i][j] || map[i][j] == 0) continue;
                    cnt++;

                    Queue<int[]> Q = new LinkedList<>();

                    Q.offer(new int[]{i, j});
                    vis[i][j] = true;

                    while (!Q.isEmpty()) {
                        int[] cur = Q.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if (map[nx][ny] == 0 || vis[nx][ny]) continue;

                            Q.offer(new int[]{nx, ny});
                            vis[nx][ny] = true;
                        }
                    }
                }
            }
            System.out.println(cnt);
        }

    }
}
