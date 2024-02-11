import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;

    static int N;
    static int[] P;
    static long ans = 0L;

    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
    static List<int[]> L = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int z = Integer.parseInt(stk.nextToken());
            L.add(new int[]{i, x, y, z});
        }

        for (int i = 1; i <= 3; i++) {
            final int cur = i;
            L.sort((o1, o2) -> o1[cur] - o2[cur]);

            int[] prev = L.get(0);
            for (int j = 1; j < N; j++) {
                int[] next = L.get(j);
                pq.offer(new int[]{prev[0], next[0], Math.abs(next[cur] - prev[cur])});
                prev = next;
            }
        }

        P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = i;
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (Union(cur[0], cur[1])) {
                ans += cur[2];
            }
        }
        System.out.println(ans);
    }

    static int Find(int x) {
        if (P[x] == x) return x;
        return P[x] = Find(P[x]);
    }

    static boolean Union(int x, int y) {
        int px = Find(x);
        int py = Find(y);

        if (px == py) return false;

        P[py] = px;
        return true;
    }
}