import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;

    static int T, F, cur;
    static Map<String, Integer> map;
    static int[] P, cnt;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            map = new HashMap<>();
            cur = -1;
            F = Integer.parseInt(br.readLine());
            P = new int[2 * F];

            for (int i = 0; i < 2 * F; i++) {
                P[i] = i;
            }
            cnt = new int[2 * F];
            Arrays.fill(cnt, 1);

            for (int f = 0; f < F; f++) {
                stk = new StringTokenizer(br.readLine());
                int p1, p2;

                String f1 = stk.nextToken();
                if ((p1 = map.getOrDefault(f1, -1)) == -1) {
                    map.put(f1, ++cur);
                    p1 = cur;
                }
                String f2 = stk.nextToken();
                if ((p2 = map.getOrDefault(f2, -1)) == -1) {
                    map.put(f2, ++cur);
                    p2 = cur;
                }
                sb.append(Union(p1, p2)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int Find(int x) {
        if (P[x] == x) return x;
        return P[x] = Find(P[x]);
    }

    static int Union(int x, int y) {
        int px = Find(x);
        int py = Find(y);

        if (px == py) return cnt[px];

        P[px] = py;
        cnt[py] += cnt[px];
        cnt[px] = 0;
        return cnt[py];
    }
}