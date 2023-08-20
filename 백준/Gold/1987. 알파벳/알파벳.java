import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;

    static int R, C, max = 0;
    static boolean[] vis;
    static char[][] board;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        stk = new StringTokenizer(br.readLine());

        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());

        board = new char[R][C];
        vis = new boolean[26];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        vis[board[0][0] - 'A'] = true;
        BT(1, 0, 0);

        System.out.println(max);
    }

    public static void BT(int L, int x, int y) {
        if (L == 27) return;

        max = Math.max(max, L);

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

            int next = board[nx][ny] - 'A';
            if (vis[next]) continue;

            vis[next] = true;
            BT(L + 1, nx, ny);
            vis[next] = false;
        }
    }
}