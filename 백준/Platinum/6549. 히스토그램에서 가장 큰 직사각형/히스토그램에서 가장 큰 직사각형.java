import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;

    static int N, startIdx;
    static long max;
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        while (true) {
            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            if (N == 0) {
                System.out.println(sb);
                return;
            }
            startIdx = 1;
            for (int i = 0; startIdx < N; i++) {
                startIdx = (int) Math.pow(2, i);
            }
            tree = new int[3][2 * startIdx];

            max = 0;
            for (int i = startIdx; i < startIdx + N; i++) {
                tree[0][i] = tree[1][i] = i;
                tree[2][i] = Integer.parseInt(stk.nextToken());
                max = Math.max(max, tree[2][i]);
            }
            for (int i = startIdx + N; i < 2 * startIdx; i++) {
                tree[0][i] = tree[1][i] = i;
            }
            for (int i = startIdx - 1; i > 0; i--) {
                tree[0][i] = tree[0][2 * i];
                tree[1][i] = tree[1][2 * i + 1];
                calArea(tree[0][i], tree[1][i]);
            }
            sb.append(max).append("\n");
        }
    }

    static void calArea(int L, int R) {
        long h = tree[2][(L + R) / 2], w = 1;
        long maxArea = h * w;
        int toL = (L + R) / 2, toR = (L + R) / 2;

        while (L <= toL - 1 && toR + 1 <= R) {
            if (tree[2][toL - 1] > tree[2][toR + 1]) {
                h = Math.min(h, tree[2][--toL]);
            } else {
                h = Math.min(h, tree[2][++toR]);
            }
            maxArea = Math.max(maxArea, (++w) * h);
        }
        while (L <= toL - 1) {
            h = Math.min(h, tree[2][--toL]);
            maxArea = Math.max(maxArea, (++w) * h);
        }
        while (toR + 1 <= R) {
            h = Math.min(h, tree[2][++toR]);
            maxArea = Math.max(maxArea, (++w) * h);
        }
        max = Math.max(max, maxArea);
    }
}