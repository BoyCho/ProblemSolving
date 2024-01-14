import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    static int N, M;
    static int[] P;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            P[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (stk.nextToken().equals("1")) {
                    Union(i, j);
                }
            }
        }

        stk = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(stk.nextToken());
        for (int i = 1; i < M; i++) {
            int next = Integer.parseInt(stk.nextToken());
            if (Find(prev) != Find(next)) {
                System.out.println("NO");
                return;
            }
            prev = next;
        }
        System.out.println("YES");
    }

    static int Find(int x) {
        if (P[x] == x) return x;
        return P[x] = Find(P[x]);
    }

    static void Union(int x, int y) {
        int px = Find(x);
        int py = Find(y);

        if (px != py)
            P[px] = py;
    }
}