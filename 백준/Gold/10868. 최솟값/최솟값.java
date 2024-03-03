import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;

    static int N, M, stIdx = 1;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        while (stIdx < N) {
            stIdx *= 2;
        }

        tree = new int[2 * stIdx];
        for (int i = stIdx; i < stIdx + N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }
        for (int i = stIdx + N; i < tree.length; i++) {
            tree[i] = Integer.MAX_VALUE;
        }
        for (int i = stIdx - 1; i > 0; i--) {
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            getMin(a + stIdx - 1, b + stIdx - 1);
        }
        System.out.print(sb);
    }

    static void getMin(int l, int r) {
        if (l > r) {
            int tmp = l;
            l = r;
            r = tmp;
        }

        int min = tree[l];
        while (l <= r) {
            if (l % 2 == 1) {
                min = Math.min(min, tree[l]);
            }
            if (r % 2 == 0) {
                min = Math.min(min, tree[r]);
            }
            l = (l + 1) / 2;
            r = (r - 1) / 2;
        }
        sb.append(min).append("\n");
    }
}