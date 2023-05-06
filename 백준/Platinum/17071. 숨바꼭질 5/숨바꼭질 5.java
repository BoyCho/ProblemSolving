import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        if (N == K)
            System.out.println(0);
        else
            System.out.println(bfs(N, K));
    }

    static int bfs(int N, int K) {
        int[][] vis = new int[500001][2];
        vis[N][0] = 1;

        Queue<Integer> Q = new LinkedList<>();
        Q.add(N);

        int sec = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            K += ++sec;
            if (K > 500000) return -1;

            while (len-- > 0) {
                int cur = Q.poll();

                for (int next: new int[]{cur - 1, cur + 1, cur * 2}) {
                    if (next < 0 || next > 500000 || vis[next][sec % 2] == 1) continue;

                    vis[next][sec % 2] = 1;
                    Q.add(next);
                }
                if (vis[K][sec % 2] == 1) return sec;
            }
        }
        return -1;
    }
}