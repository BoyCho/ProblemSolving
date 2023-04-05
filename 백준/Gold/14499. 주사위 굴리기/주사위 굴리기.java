import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());

        int[][] d = new int[4][3];

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        while (order-- > 0) {
            int dir = Integer.parseInt(st.nextToken());
            if (dir == 1) {
                if (y+1 == m) continue;
                y++;

                int tmp = d[3][1];
                d[3][1] = d[1][0];
                d[1][0] = d[1][1];
                d[1][1] = d[1][2];
                d[1][2] = tmp;
            }
            if (dir == 2) {
                if (y-1 < 0) continue;
                y--;

                int tmp = d[3][1];
                d[3][1] = d[1][2];
                d[1][2] = d[1][1];
                d[1][1] = d[1][0];
                d[1][0] = tmp;
            }
            if (dir == 3) {
                if (x-1 < 0) continue;
                x--;

                int tmp = d[3][1];
                d[3][1] = d[2][1];
                d[2][1] = d[1][1];
                d[1][1] = d[0][1];
                d[0][1] = tmp;
            }
            if (dir == 4) {
                if (x+1 == n) continue;
                x++;

                int tmp = d[0][1];
                d[0][1] = d[1][1];
                d[1][1] = d[2][1];
                d[2][1] = d[3][1];
                d[3][1] = tmp;
            }

            if (map[x][y] == 0) map[x][y] = d[1][1];
            else {
                d[1][1] = map[x][y];
                map[x][y] = 0;
            }
            System.out.println(d[3][1]);
        }
    }
}
