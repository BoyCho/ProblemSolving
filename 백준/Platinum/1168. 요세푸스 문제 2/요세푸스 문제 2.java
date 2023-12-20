import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;

    static int N, K, stIdx;
    static int target;
    static int[] tree;
    static Queue<Integer> removeQ = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        init();
        pick();
    }

    static void init() throws IOException {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        stIdx = 1;
        for (int i = 0; stIdx < N; i++) {
            stIdx = (int) Math.pow(2, i);
        }
        tree = new int[2 * stIdx];
        for (int i = stIdx; i < stIdx + N; i++) {
            tree[i] = 1;
        }
        for (int i = stIdx - 1; i >= 1; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    static void pick() {
        target = K;
        sb.append("<");
        while (tree[1] > 0) {
            while (target <= tree[1]) {
                int cur = 1;
                int tmp = target;
                while (cur < stIdx) {
                    if (tmp <= tree[2 * cur])
                        cur = 2 * cur;
                    else {
                        tmp -= tree[2 * cur];
                        cur = 2 * cur + 1;
                    }
                }
                removeQ.offer(cur);
                target += K;
            }
            target -= tree[1];
            remove();
        }
        System.out.println(sb.substring(0, sb.length() - 2) + ">");
    }

    static void remove() {
        while (!removeQ.isEmpty()) {
            int cur = removeQ.poll();
            sb.append(cur - stIdx + 1).append(", ");
            tree[cur] = 0;
            while (cur > 1) {
                cur /= 2;
                tree[cur]--;
            }
        }
    }
}