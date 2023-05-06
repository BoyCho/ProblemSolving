import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        Map<Integer, Integer> time = new HashMap<>();
        int maxSec = 0;
        while (K <= 500000) {
            time.put(K, maxSec++);
            K += maxSec;
        }

        // 예시: 11 1
        int ans = maxSec;
        int t = time.getOrDefault(N, -1);
        if (t >= 0 && t % 2 == 0)
            ans = Math.min(ans, t);

        int[][] vis = new int[500001][2];
        vis[N][0] = 1;

        Queue<Integer> Q = new LinkedList<>();
        Q.add(N);

        int sec = 0;
        while (!Q.isEmpty() && sec < maxSec) {
            int len = Q.size();
            sec++;
            while (len-- > 0) {
                int cur = Q.poll();

                for (int next: new int[]{cur + 1, cur - 1, cur * 2}) {
                    if (next < 0 || next > 500000 || vis[next][sec % 2] == 1) continue;

                    t = time.getOrDefault(next, -1);
                    if (t >= sec && (t - sec) % 2 == 0)
                        ans = Math.min(ans, t);

                    vis[next][sec % 2] = 1;
                    Q.add(next);
                }
            }
        }
        ans = (ans == maxSec) ? -1 : ans;
        System.out.println(ans);
    }
}