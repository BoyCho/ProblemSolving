import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;

    static int N;
    static int[][] d;
    static int[] R, G ,B;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        d = new int[N][3];

        R = new int[N];
        G = new int[N];
        B = new int[N];

        /*
        d[n][0] : n번 째 집이 빨강일 때의 최솟값
        d[n][1] : n번 째 집이 초록일 때의 최솟값
        d[n][2] : n번 째 집이 파랑일 때의 최솟값

        d[n][0] = d[n-1][1] 과 d[n-1][2] 의 최솟값 + R[n]
         */

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());

            R[i] = Integer.parseInt(stk.nextToken());
            G[i] = Integer.parseInt(stk.nextToken());
            B[i] = Integer.parseInt(stk.nextToken());
        }

        d[0][0] = R[0];
        d[0][1] = G[0];
        d[0][2] = B[0];

        for (int i = 1; i < N; i++) {
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + R[i];
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + G[i];
            d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + B[i];
        }
        System.out.println(Math.min(Math.min(d[N - 1][0], d[N - 1][1]), Math.min(d[N - 1][1], d[N - 1][2])));
    }
}
