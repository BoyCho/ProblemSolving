import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;

    static int[][] tree;
    static boolean[] vis;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        tree = new int[3][N + 1];
        vis = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());

            int cur = Integer.parseInt(stk.nextToken());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            tree[1][cur] = a;
            tree[2][cur] = b;

            if (a != -1) tree[0][a] = cur;
            if (b != -1) tree[0][b] = cur;
        }

        int cur = 1, cnt = 0;
        vis[1] = true;
        while (true) {
            if (tree[1][cur] != -1 && !vis[tree[1][cur]]) {
                int next = tree[1][cur];
                vis[next] = true;
                cur = next;
                cnt++;
                continue;
            }
            if (tree[2][cur] != -1 && !vis[tree[2][cur]]) {
                int next = tree[2][cur];
                vis[next] = true;
                cur = next;
                cnt++;
                continue;
            }
            if (isEndNode(cur)) break;

            cur = tree[0][cur];
            cnt++;
        }
        System.out.println(cnt);
    }

    static boolean isEndNode(int cur) {
        while (cur != 1) {
            int parent = tree[0][cur];
            if (tree[1][parent] == cur) return false;
            cur = parent;
        }
        return true;
    }
}
