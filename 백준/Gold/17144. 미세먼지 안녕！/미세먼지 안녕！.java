import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][][] map = new int[R][C][2];
        int x1 = 0, x2 = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j][0] = Integer.parseInt(st.nextToken());
                if (map[i][j][0] == -1) {
                    if (x1 == 0) x1 = i;
                    else x2 = i;
                }
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int L = 0;
        while (L++ < T) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j][0] <= 4) continue;

                    int cnt = 0;
                    int movingAmount = map[i][j][0] / 5;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];

                        if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny][0] == -1) continue;
                        map[nx][ny][1] += movingAmount;
                        cnt++;
                    }
                    map[i][j][0] -= movingAmount * cnt;
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    map[i][j][0] += map[i][j][1];
                    map[i][j][1] = 0;
                }
            }

            //clean
            for (int i = x1 - 1; i > 0; i--) map[i][0][0] = map[i-1][0][0];
            for (int i = 0; i < C - 1; i++) map[0][i][0] = map[0][i+1][0];
            for (int i = 0; i < x1; i++) map[i][C-1][0] = map[i+1][C-1][0];
            for (int i = C - 1; i > 1; i--) map[x1][i][0] = map[x1][i-1][0];
            map[x1][1][0] = 0;

            for (int i = x2 + 1; i < R - 1; i++) map[i][0][0] = map[i+1][0][0];
            for (int i = 0; i < C - 1; i++) map[R-1][i][0] = map[R-1][i+1][0];
            for (int i = R - 1; i > x2; i--) map[i][C-1][0] = map[i-1][C-1][0];
            for (int i = C - 1; i > 1; i--) map[x2][i][0] = map[x2][i-1][0];
            map[x2][1][0] = 0;
        }

        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++)
                ans += map[i][j][0];
        }
        System.out.println(ans + 2);
    }
}
