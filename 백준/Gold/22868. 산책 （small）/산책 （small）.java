import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] R;
    static int[] visF, visB;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        R = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            R[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            R[a].add(b);
            R[b].add(a);
        }

        for (int i = 1; i <= N; i++)
            Collections.sort(R[i]);

        stk = new StringTokenizer(br.readLine());

        int st = Integer.parseInt(stk.nextToken());
        int en = Integer.parseInt(stk.nextToken());
        int ans = 0;

        visF = new int[N + 1];
        ans += BFS(st, en, visF);

        visB = new int[N + 1];
        getTrace(st, en);

        ans += BFS(en, st, visB);

        System.out.println(ans);
    }

    static int BFS(int st, int en, int[] vis) {

        Queue<Integer> Q = new ArrayDeque<>();
        Q.offer(st);
        vis[st] = st;

        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            while (len-- > 0) {
                int cur = Q.poll();

                for (int next : R[cur]) {
                    if (vis[next] != 0) continue;

                    vis[next] = cur;
                    if (next == en) return L + 1;
                    Q.offer(next);
                }
            }
            L++;
        }
        return L;
    }

    static void getTrace(int st, int en) {
        int cur = en;

        while (cur != st) {
            visB[cur] = 1;
            cur = visF[cur];
        }
    }
}