import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] map = new int[N + 2][N + 2];
        for (int i = 0; i <= N + 1; i++)
            map[0][i] = map[i][0] = map[N + 1][i] = map[i][N + 1] = 1;

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
        }

        Map<Integer, Character> D = new HashMap<>();
        int L = Integer.parseInt(br.readLine());
        while (L-- > 0) {
            st = new StringTokenizer(br.readLine());
            D.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }

        Queue<int[]> Body = new LinkedList<>();
        Body.add(new int[]{1, 1});

        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        int[] cur = new int[]{1,1};
        int T = 0, dir = 0, len = 1;

        while (true) {
            cur[0] += dx[dir];
            cur[1] += dy[dir];
            T++;

            for (int[] b: Body) {
                if (b[0] == cur[0] && b[1] == cur[1]) {
                    System.out.println(T); return;
                }
            }
            if (map[cur[0]][cur[1]] == 1) {
                System.out.println(T); return;
            }

            if (map[cur[0]][cur[1]] == 2) {
                len++;
                map[cur[0]][cur[1]] = 0;
            }
            if (Body.size() == len) Body.poll();
            Body.add(new int[]{cur[0], cur[1]});

            if (D.get(T) != null) {
               if (D.get(T) == 'D') dir = (dir + 1) % 4;
               else dir = dir - 1 < 0 ? 3 : dir - 1;
            }
        }

    }
}