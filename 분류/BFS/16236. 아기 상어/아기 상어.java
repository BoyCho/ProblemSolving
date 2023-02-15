import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map, vis;

    static class Node implements Comparable<Node> {
        private final int x, y;
        private int sec;

        public Node(int x, int y, int sec) {
            this.x = x;
            this.y = y;
            this.sec = sec;
        }

        @Override
        public int compareTo(Node o) {
            if (vis[o.y][o.x] == vis[this.y][this.x]) {
                if (this.y == o.y)
                    return this.x - o.x;
                return this.y - o.y;
            }
            return vis[this.y][this.x] - vis[o.y][o.x];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Queue<Node> que = new PriorityQueue<>();

        map = new int[n][n];
        vis = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    que.add(new Node(j, i, 0));
                    map[i][j] = 0;
                    vis[i][j] = 1;
                }
            }
        }

        int[] dy = {-1, 0, 0, 1};
        int[] dx = {0, -1, 1, 0};
        int size = 2, eat = 0;
        int ans = 0;

        while (!que.isEmpty()) {
            Node cur = que.poll();

            if (map[cur.y][cur.x] != 0 && size > map[cur.y][cur.x]) {

                map[cur.y][cur.x] = 0;
                ans += cur.sec;
                cur.sec = 0;

                if (eat + 1 == size) {
                    size++;
                    eat = 0;
                } else eat++;

                vis = new int[n][n];
                vis[cur.y][cur.x] = 1;

                que.clear();
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (vis[ny][nx] != 0 || map[ny][nx] > size) continue;

                vis[ny][nx] = vis[cur.y][cur.x] + 1;

                que.add(new Node(nx, ny, cur.sec + 1));
            }
        }
        System.out.println(ans);
    }
}
