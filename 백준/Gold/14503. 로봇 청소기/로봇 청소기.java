import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir_ = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] cur = new int[]{x, y, dir_};
        map[x][y] = 2;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int cnt = 1;

        while(true) {
            boolean clean = false;
            int dir = cur[2] - 1 < 0 ? 3 : cur[2] - 1;
            for (int i = 0; i < 4; i++, dir = dir - 1 < 0 ? 3 : dir - 1) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (map[nx][ny] == 1 || map[nx][ny] == 2) continue;

                clean = true;
                cnt++;

                cur = new int[]{nx, ny, dir};
                map[nx][ny] = 2;
                break;
            }

            if (clean) continue;

            int nx = cur[0] + dx[(cur[2] + 2) % 4];
            int ny = cur[1] + dy[(cur[2] + 2) % 4];
            if (map[nx][ny] == 1) {
                System.out.println(cnt);
                return;
            }
            cur = new int[]{nx, ny, cur[2]};
        }
    }
}