import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;

    static int N, M, H = 0;
    static int[][] P;
    static int[] depth;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        depth = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        H = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        P = new int[N + 1][H + 1];

        init(1, 1, 0);

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                P[j][i] = P[P[j][i - 1]][i - 1];
            }
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            sb.append(LCA(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    static void init(int h, int cur, int parent) {
        depth[cur] = h;
        for (int next : tree[cur]) {
            if (next == parent) continue;
            init(h + 1, next, cur);
            P[next][0] = cur;
        }
    }

    static int LCA(int a, int b) {
        if (depth[b] > depth[a]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        for (int i = H; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = P[a][i];
            }
        }

        if (a == b) return a;

        for (int i = H; i >= 0; i--) {
            if (P[a][i] != P[b][i]) {
                a = P[a][i];
                b = P[b][i];
            }
        }

        return P[a][0];
    }
}