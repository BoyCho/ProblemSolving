import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;

    static int V, end;
    static long max;
    static boolean[] vis;
    static List<int[]>[] nodes;

    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());

        nodes = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= V; i++) {
            stk = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(stk.nextToken());

            while (true) {
                int node = Integer.parseInt(stk.nextToken());
                if (node == -1) break;
                int cost = Integer.parseInt(stk.nextToken());

                nodes[cur].add(new int[]{node, cost});
            }
        }
        vis = new boolean[V + 1];
        max = 0;
        vis[1] = true;
        DFS(1, 0, false);

        vis = new boolean[V + 1];
        max = 0;
        vis[end] = true;
        DFS(end, 0, true);

        System.out.println(max);
    }

    static void DFS(int n, long sum, boolean isEndPicked) {
        if (sum > max) {
            max = sum;
            if (!isEndPicked) end = n;
        }
        for (int[] cur : nodes[n]) {
            int next = cur[0];
            int cost = cur[1];

            if (vis[next]) continue;
            vis[next] = true;
            DFS(next, sum + cost, isEndPicked);
        }
    }
}