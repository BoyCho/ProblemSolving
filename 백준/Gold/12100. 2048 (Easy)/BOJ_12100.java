import java.util.*;
import java.io.*;

public class Main {

    static int N, max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        StringTokenizer tk;
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(tk.nextToken());
        }

        max = 0;
        dfs(0, map);
        System.out.println(max);
    }

    static void dfs(int d, int[][] map) {
        if (d == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    max = Math.max(max, map[i][j]);
            }
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int[][] m = new int[N][N];
            for (int i = 0; i < N; i++)
                System.arraycopy(map[i], 0, m[i], 0, N);

            for (int i = 0; i < N; i++) {
                int st, en;
                boolean isMerged = true;

                switch (dir) {
                    case 0:
                        st = 0;
                        en = 1;
                        while (en < N) {
                            while (st < N && m[i][st] != 0) st++;
                            if (en <= st) en = st + 1;

                            if (en < N && m[i][en] != 0) {
                                m[i][st++] = m[i][en];
                                m[i][en] = 0;
                            }
                            en++;
                        }

                        for (int j = N - 1; j > 0; j--) {
                            if (m[i][j] != 0 && m[i][j] == m[i][j-1]) {
                                m[i][j] *= 2;
                                m[i][j-1] = 0;
                            }
                        }

                        st = 0;
                        en = 1;
                        while (en < N) {
                            while (st < N && m[i][st] != 0) st++;
                            if (en <= st) en = st + 1;

                            if (en < N && m[i][en] != 0) {
                                m[i][st++] = m[i][en];
                                m[i][en] = 0;
                            }
                            en++;
                        }
                        break;

                    case 1:
                        st = 0;
                        en = 1;
                        while (en < N) {
                            while (st < N && m[st][i] != 0) st++;
                            if (en <= st) en = st + 1;

                            if (en < N && m[en][i] != 0) {
                                m[st++][i] = m[en][i];
                                m[en][i] = 0;
                            }
                            en++;
                        }

                        for (int j = N - 1; j > 0; j--) {
                            if (m[j][i] != 0 && m[j][i] == m[j-1][i]) {
                                m[j][i] *= 2;
                                m[j-1][i] = 0;
                            }
                        }

                        st = 0;
                        en = 1;
                        while (en < N) {
                            while (st < N && m[st][i] != 0) st++;
                            if (en <= st) en = st + 1;

                            if (en < N && m[en][i] != 0) {
                                m[st++][i] = m[en][i];
                                m[en][i] = 0;
                            }
                            en++;
                        }
                        break;

                    case 2:
                        st = N - 1;
                        en = N - 2;
                        while (en >= 0) {
                            while (st >= 0 && m[i][st] != 0) st--;
                            if (en >= st) en = st - 1;

                            if (en >= 0 && m[i][en] != 0) {
                                m[i][st--] = m[i][en];
                                m[i][en] = 0;
                            }
                            en--;
                        }

                        for (int j = 0; j < N - 1; j++) {
                            if (m[i][j] != 0 && m[i][j] == m[i][j+1]) {
                                m[i][j] *= 2;
                                m[i][j+1] = 0;
                            }
                        }

                        st = N - 1;
                        en = N - 2;
                        while (en >= 0) {
                            while (st >= 0 && m[i][st] != 0) st--;
                            if (en >= st) en = st - 1;

                            if (en >= 0 && m[i][en] != 0) {
                                m[i][st--] = m[i][en];
                                m[i][en] = 0;
                            }
                            en--;
                        }

                        break;

                    case 3:
                        st = N - 1;
                        en = N - 2;
                        while (en >= 0) {
                            while (st >= 0 && m[st][i] != 0) st--;
                            if (en >= st) en = st - 1;

                            if (en >= 0 && m[en][i] != 0) {
                                m[st--][i] = m[en][i];
                                m[en][i] = 0;
                            }
                            en--;
                        }

                        for (int j = 0; j < N - 1; j++) {
                            if (m[j][i] != 0 && m[j][i] == m[j+1][i]) {
                                m[j][i] *= 2;
                                m[j+1][i] = 0;
                            }
                        }

                        st = N - 1;
                        en = N - 2;
                        while (en >= 0) {
                            while (st >= 0 && m[st][i] != 0) st--;
                            if (en >= st) en = st - 1;

                            if (en >= 0 && m[en][i] != 0) {
                                m[st--][i] = m[en][i];
                                m[en][i] = 0;
                            }
                            en--;
                        }
                        break;
                }
            }
            dfs(d + 1, m);
        }
    }
}
/*
3
2 2 2
4 4 4
8 8 8

3
4 0 0
4 0 0
4 0 0

10
16 16 8 32 32 0 0 8 8 8
16 0 0 0 0 8 0 0 0 16
0 0 0 0 0 0 0 0 0 2
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0

10
8 8 4 16 32 0 0 8 8 8
8 8 4 0 0 8 0 0 0 0
16 0 0 16 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 16
0 0 0 0 0 0 0 0 0 2
 */