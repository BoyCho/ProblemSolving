import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<int[]> iceBurgQ = new LinkedList<>();
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0)
                    iceBurgQ.offer(new int[]{i, j, map[i][j]});
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int L = 0;

        while (!iceBurgQ.isEmpty()) {
            int x = iceBurgQ.peek()[0];
            int y = iceBurgQ.peek()[1];

            Queue<int[]> Q = new LinkedList<>();
            boolean[][] vis = new boolean[N][M];

            Q.offer(new int[]{x, y});
            vis[x][y] = true;

            while (!Q.isEmpty()) {
                int[] cur = Q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || vis[nx][ny] || map[nx][ny] == 0) continue;

                    Q.offer(new int[]{nx, ny});
                    vis[nx][ny] = true;
                }
            }

            int len = iceBurgQ.size();
            while (len-- > 0) {
                int[] cur = iceBurgQ.poll();

                if (!vis[cur[0]][cur[1]]) {
                    System.out.println(L);
                    return;
                }

                int ice = cur[2];
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (map[nx][ny] == 0) ice = Math.max(0, ice - 1);
                }
                iceBurgQ.offer(new int[]{cur[0], cur[1], ice});
            }

            len = iceBurgQ.size();
            while (len-- > 0) {
                int[] cur = iceBurgQ.poll();
                map[cur[0]][cur[1]] = cur[2];

                if (cur[2] == 0) continue;
                iceBurgQ.offer(new int[]{cur[0], cur[1], cur[2]});
            }
            L++;
        }
        System.out.println(0);
    }
}
