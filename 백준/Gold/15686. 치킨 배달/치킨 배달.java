import java.io.*;
import java.util.*;

public class Main {

    static List<int[]> H, S;
    static int[] vis;
    static int N, M, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        H = new ArrayList<>();  // 집
        S = new ArrayList<>();  // 치킨 가게

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());

                if (v == 1) H.add(new int[]{i, j});
                if (v == 2) S.add(new int[]{i, j, 0});
            }
        }

        vis = new int[S.size()];
        answer = Integer.MAX_VALUE;

        dfs(0,0);
        System.out.println(answer);
    }

    static void dfs(int d, int s) {
        if (d == M) {
            int totalDist = 0;
            for (int[] house: H) {
                int minDist = Integer.MAX_VALUE;
                for (int i = 0; i < S.size(); i++) {
                    if (vis[i] == 0) continue;
                    minDist = Math.min(minDist, Math.abs(S.get(i)[0] - house[0]) + Math.abs(S.get(i)[1] - house[1]));
                }
                totalDist += minDist;
            }
            answer = Math.min(answer, totalDist);
            return;
        }
        for (int i = s; i < vis.length; i++) {
            vis[i] = 1;
            dfs(d + 1, i + 1);
            vis[i] = 0;
        }
    }
}