import java.io.*;
import java.util.*;

public class Main {

    static int ans, N, M;
    static int[][] map;

    static List<int[]> cctvList = new ArrayList<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ans = N * M;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (0 < map[i][j] && map[i][j] < 6)
                    cctvList.add(new int[]{i, j, map[i][j]});
            }
        }
        dfs(0);
        System.out.println(ans);
    }

    public static void dfs(int L) {
        if (L == cctvList.size()) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) cnt++;
                }
            }
            ans = Math.min(ans, cnt);
            return;
        }

        int x = cctvList.get(L)[0];
        int y = cctvList.get(L)[1];
        int num = cctvList.get(L)[2];

        if (num == 5) {
            cctv5(x, y, L + 1, L + 1);
            dfs(L + 1);
            cctv5(x, y, 0, L + 1);
            return;
        }

        for (int i = 0; i < 4; i++) {
            switch (num) {
                case 1:
                    cctv1(x, y, i, L + 1, L + 1);
                    dfs(L + 1);
                    cctv1(x, y, i, 0, L + 1);
                    break;
                case 2:
                    cctv2(x, y, i, L+1, L + 1);
                    dfs(L + 1);
                    cctv2(x, y, i, 0, L + 1);
                    break;
                case 3:
                    cctv3(x, y, i, L + 1, L + 1);
                    dfs(L + 1);
                    cctv3(x, y, i, 0, L + 1);
                    break;
                case 4:
                    cctv4(x, y, i, L + 1, L + 1);
                    dfs(L + 1);
                    cctv4(x, y, i, 0, L + 1);
                    break;
            }
        }
    }

    public static void check(int x, int y, int dir, int set, int pick) {
        int nx = x, ny = y;

        while (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != 6) {
            if (set == 0 && map[nx][ny] == pick * -1)
                map[nx][ny] = set;
            if (set == pick && map[nx][ny] == 0)
                map[nx][ny] = set * -1;
            nx += dx[dir];
            ny += dy[dir];
        }
    }

    public static void cctv1(int x, int y, int dir, int set, int pick) {
        check(x, y, dir, set, pick);
    }

    public static void cctv2(int x, int y, int dir, int set, int pick) {
        check(x, y, dir, set, pick);
        check(x, y, (dir + 2) % 4, set, pick);
    }

    public static void cctv3(int x, int y, int dir, int set, int pick) {
        check(x, y, dir, set, pick);
        check(x, y, (dir + 1) % 4, set, pick);
    }

    public static void cctv4(int x, int y, int dir, int set, int pick) {
        check(x, y, dir, set, pick);
        check(x, y, (dir + 1) % 4, set, pick);
        check(x, y, (dir + 2) % 4, set, pick);
    }

    public static void cctv5(int x, int y, int set, int pick) {
        for (int i = 0; i < 4; i++)
            check(x, y, i, set, pick);
    }
}
