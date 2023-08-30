import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;

    static int H, W, cnt;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        init();
        check();
        System.out.println(cnt);
    }

    public static void init() throws IOException {
        stk = new StringTokenizer(br.readLine());

        H = Integer.parseInt(stk.nextToken());
        W = Integer.parseInt(stk.nextToken());

        map = new boolean[H][W];

        stk = new StringTokenizer(br.readLine());
        for (int j = 0; j < W; j++) {
            int len = Integer.parseInt(stk.nextToken());
            for (int i = 0; i < len; i++)
                map[H - 1 - i][j] = true;
        }
        cnt = 0;
    }

    public static void check() {
        for (int i = 0; i < H; i++) {
            int st = -1;
            for (int j = 0; j < W; j++) {
                if (!map[i][j]) continue;
                if (st == -1) {
                    st = j;
                    continue;
                }
                cnt += j - st - 1;
                st = j;
            }
        }
    }
}
