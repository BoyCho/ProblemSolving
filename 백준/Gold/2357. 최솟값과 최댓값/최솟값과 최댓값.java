import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;
    static int N, M;
    static int[] maxTree, minTree;

    public static void main(String[] args) throws IOException {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        int startIdx = 1;
        for (int i = 0; startIdx < N; i++) {
            startIdx = (int)Math.pow(2, i);
        }
        maxTree = new int[2 * startIdx];
        minTree = new int[2 * startIdx];
        Arrays.fill(minTree, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            maxTree[i + startIdx] = minTree[i + startIdx]
                    = Integer.parseInt(br.readLine());
        }
        for (int i = startIdx - 1; i > 0; i--) {
            maxTree[i] = Math.max(maxTree[2 * i], maxTree[2 * i + 1]);
            minTree[i] = Math.min(minTree[2 * i], minTree[2 * i + 1]);
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken()) + startIdx - 1;
            int en = Integer.parseInt(stk.nextToken()) + startIdx - 1;
            getMinAndMax(st, en);
        }
        System.out.println(sb);
    }

    static void getMinAndMax(int st, int en) {
        int min = Integer.MAX_VALUE, max = 0;

        while (st <= en) {
            if (st % 2 == 1) {
                min = Math.min(minTree[st], min);
                max = Math.max(maxTree[st], max);
            }
            st = (st + 1) / 2;
            if (en % 2 == 0) {
                min = Math.min(minTree[en], min);
                max = Math.max(maxTree[en], max);
            }
            en = (en - 1) / 2;
        }
        sb.append(min).append(" ").append(max).append("\n");
    }
}