import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{
        private int x, y;
        private int size, eat, sec;

        public Node(int x, int y, int size, int eat, int sec) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eat = eat;
            this.sec = sec;
        }

        @Override
        public int compareTo(Node o) {
            if ( this.size == o.size ) {
                if (this.x == o.x)
                    return this.y - o.y;
                return this.x - o.x;
            }
            return this.size - o.size;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Queue<Node> que = new LinkedList<>();

        int[][] map = new int[n][n];
        int[][] vis = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    que.add(new Node(j ,i ,2 ,0, 0));
                    map[i][j] = 0;
                    vis[i][j] = 1;
                }
            }
        }

        int[] dy = {0,1,0,-1};
        int[] dx = {-1,0,1,0};
        int ans = 0;

        while (!que.isEmpty()) {
            Node cur = que.poll();

            /*for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++)
                    System.out.print(map[k][j] + " ");
                System.out.println();
            }
            System.out.println(cur.size + " " + cur.eat);
            System.out.println();*/
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (vis[ny][nx] != 0 || map[ny][nx] > cur.size) continue;

                vis[ny][nx] = 1;

                if (map[ny][nx] != 0 && map[ny][nx] < cur.size) {
                    vis = new int[n][n];
                    que.clear();
                    map[ny][nx] = 0;
                    ans += cur.sec + 1;

                    for (int k = 0; k < n; k++) {
                        for (int j = 0; j < n; j++)
                            System.out.print(map[k][j] + " ");
                        System.out.println();
                    }
                    System.out.println(cur.size + " " + cur.eat + " " + ans);
                    System.out.println();

                    if (cur.eat + 1 == cur.size)
                        que.add(new Node(ny, nx, cur.size + 1, 0, 0));
                    else
                        que.add(new Node(ny, nx, cur.size, cur.eat + 1, 0));
                    break;
                }
                que.add(new Node(ny, nx, cur.size, cur.eat, cur.sec + 1));
            }
        }
        System.out.println(ans);
    }
}
