import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;

    static List<Integer> trip = new ArrayList<>();
    static List<Integer>[] tree;
    static int[] depth, idxInTrip, seg;
    static int N, M, stIdx = 1;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
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

        idxInTrip = new int[N + 1];
        Arrays.fill(idxInTrip, -1);
        depth = new int[N + 1];

        DFSInit(1, 1, 0);

        while (stIdx < trip.size()) {
            stIdx *= 2;
        }
        seg = new int[2 * stIdx];
        for (int i = stIdx; i < stIdx + trip.size(); i++) {
            seg[i] = trip.get(i - stIdx);
        }

        depth[0] = Integer.MAX_VALUE;
        for (int i = stIdx - 1; i > 0; i--) {
            if (depth[seg[2 * i]] < depth[seg[2 * i + 1]]) {
                seg[i] = seg[2 * i];
            } else {
                seg[i] = seg[2 * i + 1];
            }
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(stk.nextToken());
            int r = Integer.parseInt(stk.nextToken());

            l = idxInTrip[l] + stIdx;
            r = idxInTrip[r] + stIdx;

            if (l > r) {
                int tmp = l;
                l = r;
                r = tmp;
            }

            int LCA = seg[l];
            while (l <= r) {
                if (depth[seg[l]] < depth[LCA]) LCA = seg[l];
                if (depth[seg[r]] < depth[LCA]) LCA = seg[r];
                l = (l + 1) / 2;
                r = (r - 1) / 2;
            }
            sb.append(LCA).append("\n");
        }
        System.out.print(sb);
    }

    static void DFSInit(int h, int cur, int parent) {
        depth[cur] = h;
        if (idxInTrip[cur] == -1) {
            idxInTrip[cur] = trip.size();
        }
        trip.add(cur);
        for (int next : tree[cur]) {
            if (next == parent) continue;
            DFSInit(h + 1, next, cur);
            trip.add(cur);
        }
    }
}