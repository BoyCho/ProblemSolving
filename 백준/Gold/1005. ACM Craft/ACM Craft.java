import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;

    static int T, N, K;
    static long[] D, vis;
    static List<Integer>[] L;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            K = Integer.parseInt(stk.nextToken());

            stk = new StringTokenizer(br.readLine());
            D = new long[N + 1];
            for (int i = 1; i <= N; i++) {
                D[i] = Long.parseLong(stk.nextToken());
            }

            L = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                L[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                stk = new StringTokenizer(br.readLine());
                int st = Integer.parseInt(stk.nextToken());
                int en = Integer.parseInt(stk.nextToken());
                L[en].add(st);
            }

            vis = new long[N + 1];
            Arrays.fill(vis, -1L);

            int W = Integer.parseInt(br.readLine());

            Queue<long[]> Q = new ArrayDeque<>();
            Q.offer(new long[]{W, D[W]});
            vis[W] = D[W];

            long ans = 0;
            while (!Q.isEmpty()) {
                long[] cur = Q.poll();
                if (cur[1] != vis[(int) cur[0]]) continue;

                int curB = (int)cur[0];
                long cost = cur[1];
                if (L[curB].isEmpty()) {
                    ans = Math.max(ans, vis[curB]);
                }

                for (int next : L[curB]) {
                    if (vis[next] < cost + D[next]) {
                        vis[next] = cost + D[next];
                        Q.offer(new long[]{next, vis[next]});
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}