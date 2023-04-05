import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken(" "));
        }

        int[][] vis = new int[n][n];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int island = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 || vis[i][j] != 0) continue;

                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                vis[i][j] = island;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        if (map[nx][ny] == 0 || vis[nx][ny] != 0) continue;

                        q.add(new int[]{nx, ny});
                        vis[nx][ny] = island;
                    }
                }
                island++;
            }
        }

        int min = 201;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0) continue;

                int[][] tmp = new int[n][n];
                Queue<int[]> q = new LinkedList<>();

                q.add(new int[]{i, j});
                tmp[i][j] = 1;

                boolean f = false;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        if (tmp[nx][ny] == 1) continue;

                        if (vis[nx][ny] != 0 && vis[nx][ny] != vis[i][j]) {
                            min = Math.min(Math.abs(nx - i) + Math.abs(ny - j), min);
                            f = true; break;
                        }
                        if (f) break;

                        q.add(new int[]{nx, ny});
                        tmp[nx][ny] = 1;
                    }
                }
            }
        }
        System.out.println(min - 1);
    }
}
