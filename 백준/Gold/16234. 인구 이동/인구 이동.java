import java.util.*;
import java.io.*;
//10:50
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int X = Integer.parseInt(tk.nextToken());
        int Y = Integer.parseInt(tk.nextToken());

        int[][] map = new int[N][N];
        int[][] vis = new int[N][N];

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(tk.nextToken());
        }

        int st = 0, en = 1, days = 0;
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};

        boolean isChanged = true;
        while (isChanged) {
            isChanged = false;
            days++;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (st < vis[i][j] && vis[i][j] <= en) continue;

                    Queue<int[]> Q = new LinkedList<>();
                    Q.add(new int[]{i, j});
                    vis[i][j] = en;

                    List<int[]> L = new ArrayList<>();
                    L.add(new int[]{i, j});

                    int sum = map[i][j], cnt = 1;

                    while (!Q.isEmpty()) {
                        int[] cur = Q.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                            if (st < vis[nx][ny] && vis[nx][ny] <= en) continue;

                            int diff = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
                            if (diff < X || diff > Y ) continue;
                            isChanged = true;

                            sum += map[nx][ny];
                            cnt++;

                            L.add(new int[]{nx, ny});
                            Q.add(new int[]{nx, ny});
                            vis[nx][ny] = en;
                        }
                    }

                    int avg = sum / cnt;
                    for (int[] cur: L)
                        map[cur[0]][cur[1]] = avg;
                    en++;
                }
            }
            st = en - 1;
        }
        System.out.println(days - 1);
    }
}