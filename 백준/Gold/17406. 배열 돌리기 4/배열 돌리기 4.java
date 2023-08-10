import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[] vis;

    static int[][] arr, rotateArr;
    static int N, M, K, min;

    static Deque<Integer> D;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        rotateArr = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                rotateArr[i][j] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        vis = new boolean[K];

        BT(0);

        System.out.println(min);
    }

    public static void rotate(int x_, int y_, int bound, boolean type) {

        int x = x_ - bound;
        int y = y_ - bound;

        if (type) D = new ArrayDeque<>();

        for (int dir = 0; dir < 4; dir++) {
            while (true) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < x_ - bound || ny < y_ - bound || nx > x_ + bound || ny > y_ + bound) break;

                x = nx;
                y = ny;
                if (type) D.offer(arr[x][y]);
                else arr[x][y] = D.pollFirst();
            }
        }
    }

    public static void BT(int L) {
        if (L == K) {
            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int j = 1; j <= M; j++)
                    sum += arr[i][j];
                min = Math.min(min, sum);
            }
            return;
        }

        for (int i = 0; i < K; i++) {
            if (vis[i]) continue;

            vis[i] = true;
            for (int j = 1; j <= rotateArr[i][2]; j++) {
                rotate(rotateArr[i][0], rotateArr[i][1], j, true);
                D.addFirst(D.pollLast());
                rotate(rotateArr[i][0], rotateArr[i][1], j, false);
            }

            BT(L + 1);

            vis[i] = false;
            for (int j = 1; j <= rotateArr[i][2]; j++) {
                rotate(rotateArr[i][0], rotateArr[i][1], j, true);
                D.addLast(D.pollFirst());
                rotate(rotateArr[i][0], rotateArr[i][1], j, false);
            }
        }
    }
}