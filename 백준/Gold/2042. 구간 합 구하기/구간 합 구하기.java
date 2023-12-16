import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;

    static int N, M, K;
    static long[] tree;

    public static void main(String[] args) throws IOException {

        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        // 시작 인덱스 구하기
        int stIdx = 0;
        for (int k = 0; stIdx < N; k++) {
            stIdx = (int)Math.pow(2, k);
        }
        // 트리 크기 설정
        tree = new long[2 * stIdx];

        // 트리 초기화 (구간 합)
        for (int i = 0; i < N; i++) {
            tree[stIdx + i] = Long.parseLong(br.readLine());
        }
        for (int i = stIdx - 1; i >= 1; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }

        // 질의 처리
        for (int i = 0; i < M + K; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            long c = Long.parseLong(stk.nextToken());

            if (a == 1) {
                int cur = stIdx + b - 1;
                tree[cur] = c;

                while (cur / 2 != 0) {
                    if (cur % 2 == 0)
                        tree[cur / 2] = tree[cur] + tree[cur + 1];
                    else
                        tree[cur / 2] = tree[cur] + tree[cur - 1];
                    cur /= 2;
                }
            } else {
                long sum = 0;
                int st = stIdx + b - 1;
                int en = stIdx + (int)c - 1;
                while (st <= en) {
                    if (st % 2 == 1)
                        sum += tree[st];
                    st = (st + 1) / 2;
                    if (en % 2 == 0)
                        sum += tree[en];
                    en = (en - 1) / 2;
                }
                sb.append(sum).append("\n");
            }
        }
        System.out.println(sb);
    }
}
