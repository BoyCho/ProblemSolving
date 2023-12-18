import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;

    static int N, startIdx;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        init();

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            stk = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(stk.nextToken());
            int X = Integer.parseInt(stk.nextToken());

            if (T == 1) {
                update(X + startIdx - 1);
            } else {
                sb.append(delete(X)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void init() {
        startIdx = 1;
        for (int i = 0; startIdx <= 2000000; i++) {
            startIdx = (int)Math.pow(2, i);
        }
        tree = new int[2 * startIdx];
    }

    static void update(int i) {
        tree[i] += 1;
        while (i > 1) {
            i /= 2;
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    static int delete(int V) {
        int i = 1;
        tree[i]--;
        while (i < startIdx) {
            if (V <= tree[2 * i])
                i = 2 * i;
            else {
                V -= tree[2 * i];
                i = 2 * i + 1;
            }
            tree[i]--;
        }
        return i - startIdx + 1;
    }
}