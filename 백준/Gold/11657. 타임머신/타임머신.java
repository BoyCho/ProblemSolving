import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;

    static int N, M;
    static long[] dist;
    static List<int[]> edges;

    public static void main(String[] args) throws IOException {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        dist = new long[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());

            edges.add(new int[]{v, w, cost});
        }

        dist[1] = 0;
        for (int i = 0; i < N; i++) {
            for (int[] cur : edges) {
                if (dist[cur[0]] == Integer.MAX_VALUE) continue;

                if (dist[cur[0]] + cur[2] < dist[cur[1]])
                    dist[cur[1]] = dist[cur[0]] + cur[2];
            }
        }

        for (int[] cur : edges) {
            if (dist[cur[0]] == Integer.MAX_VALUE) continue;

            if (dist[cur[0]] + cur[2] < dist[cur[1]]) {
                System.out.println("-1");
                return;
            }
        }

        for (int i = 2; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("-1").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }
}