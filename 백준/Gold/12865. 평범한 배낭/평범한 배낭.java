import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    static int N, K, W, V;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            W = Integer.parseInt(stk.nextToken());
            V = Integer.parseInt(stk.nextToken());

            for (int k = 1; k <= K; k++) {
                dp[i][k] = dp[i - 1][k];
                if (k - W >= 0) {
                    dp[i][k] = Math.max(dp[i][k], dp[i - 1][k - W] + V);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}