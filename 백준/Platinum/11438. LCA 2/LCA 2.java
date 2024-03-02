import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;

    static int N, M, H;
    static int[] depth;
    static int[][] dp;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        H = (int)(Math.log(N) / Math.log(2)) + 1;

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        depth = new int[N + 1];
        dp = new int[N + 1][H + 1];
        init(1, 1, 0);

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                dp[j][i] = dp[dp[j][i - 1]][i - 1];
            }
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            sb.append(LCA(a, b)).append("\n");
        }

        System.out.print(sb);
    }

    static void init(int h, int cur, int parent) {
        depth[cur] = h;
        for (int next : tree[cur]) {
            if (next == parent) continue;
            dp[next][0] = cur;
            init(h + 1, next, cur);
        }
    }

    static int LCA(int a, int b) {
        if (depth[b] > depth[a]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        while (depth[a] > depth[b]) {
            for (int i = H; i >= 0; i--) {
                if (Math.pow(2, i) <= depth[a] - depth[b]) {
                    a = dp[a][i];
                }
            }
        }
        if (a == b) return a;

        for (int i = H; i >= 0; i--) {
            if (dp[a][i] != dp[b][i])  {
                a = dp[a][i];
                b = dp[b][i];
            }
        }
        return dp[a][0];
    }
}