import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        String[] gears = new String[4];

        for (int i = 0; i < 4; i++)
            gears[i] = br.readLine();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            stk = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(stk.nextToken()) - 1;
            int dir = Integer.parseInt(stk.nextToken());

            Queue<int[]> Q = new LinkedList<>();
            boolean[] vis = new boolean[4];

            Q.add(new int[]{num, dir});
            vis[num] = true;

            while (!Q.isEmpty()) {
                int[] cur = Q.poll();

                for (int next : new int[]{cur[0] - 1, cur[0] + 1}) {
                    if (next < 0 || next > 3 || vis[next]) continue;

                    if (next == cur[0] - 1 && gears[next].charAt(2) != gears[cur[0]].charAt(6)) {
                        Q.add(new int[]{next, cur[1] * -1});
                        vis[next] = true;
                    }
                    if (next == cur[0] + 1 && gears[next].charAt(6) != gears[cur[0]].charAt(2)) {
                        Q.add(new int[]{next, cur[1] * -1});
                        vis[next] = true;
                    }
                }

                if (cur[1] == 1)
                    gears[cur[0]] = gears[cur[0]].charAt(7) + gears[cur[0]].substring(0, 7);
                else
                    gears[cur[0]] = gears[cur[0]].substring(1, 8) + gears[cur[0]].charAt(0);
            }
        }
        int score = 0, acc = 1;
        for (int i = 0; i < 4; i++) {
            if (gears[i].charAt(0) == '1') score += acc;
            acc *= 2;
        }
        System.out.println(score);
    }
}