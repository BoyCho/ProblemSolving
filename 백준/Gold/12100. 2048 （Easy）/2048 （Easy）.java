import java.util.*;
import java.io.*;

public class Main {

    static int N, max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] block = new int[N][N];

        StringTokenizer tk;
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                block[i][j] = Integer.parseInt(tk.nextToken());
        }

        max = 0;
        dfs(0, block);
        System.out.println(max);
    }

    static void dfs(int d, int[][] curB) {
        if (d == 5) {
            for (int[] b: curB) {
                for (int num: b)
                    max = Math.max(max, num);
            }
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int[][] nextB = new int[N][N];
            for (int i = 0; i < N; i++)
                System.arraycopy(curB[i], 0, nextB[i], 0, N);

            for (int r = 0; r < dir; r++)
                rotate(nextB);

            sort(nextB);
            merge(nextB);
            sort(nextB);

            dfs(d + 1, nextB);
        }
    }

    static void rotate(int[][] block) {
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N; j++) {
                int tmp = block[i][j];
                block[i][j] = block[N - 1 - i][j];
                block[N - 1 - i][j] = tmp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int tmp = block[i][j];
                block[i][j] = block[j][i];
                block[j][i] = tmp;
            }
        }
    }

    static void sort(int[][] block) {
        for (int[] b: block) {
            int st = 0, en = 1;
            while (en < N) {
                while (st < N && b[st] != 0) st++;
                if (en <= st) en = st + 1;

                if (en >= N) break;
                if (b[en] != 0) {
                    b[st++] = b[en];
                    b[en] = 0;
                }
                en++;
            }
        }
    }

    static void merge(int[][] block) {
        for (int[] b: block) {
            for (int i = 0; i < N - 1; i++) {
                if (b[i] == b[i + 1]) {
                    b[i++] *= 2;
                    b[i] = 0;
                }
            }
        }
    }
}