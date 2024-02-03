import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;

    static int N, stIdx = 1;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; stIdx < 1000000; i++) {
            stIdx = (int) Math.pow(2, i);
        }

        tree = new long[2 * stIdx];

        for (int n = 0; n < N; n++) {
            stk = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stk.nextToken());

            if (A == 1) {
                long B = Long.parseLong(stk.nextToken());
                sb.append(pick(B)).append("\n");
            } else {
                int B = Integer.parseInt(stk.nextToken());
                long C = Long.parseLong(stk.nextToken());
                update(B + stIdx, C);
            }
        }
        System.out.println(sb);
    }

    static void update(int b, long c) {
        while (b >= 1) {
            tree[b] += c;
            b /= 2;
        }
    }

    static int pick(long b) {
        int cur = 1;
        while (cur < stIdx) {
            tree[cur]--;
            if (b <= tree[cur * 2]) {
                cur *= 2;
            } else {
                b -= tree[cur * 2];
                cur = 2 * cur + 1;
            }
        }
        tree[cur]--;
        return cur - stIdx;
    }
}