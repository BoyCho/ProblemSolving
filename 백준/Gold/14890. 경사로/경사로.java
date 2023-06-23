import java.io.*;
import java.util.*;

public class Main {

    static int N, L;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        List<int[]> roads = new ArrayList<>();
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            int[][] road = new int[2][N];
            for (int j = 0; j < N; j++) {
                road[0][j] = map[j][i];
                road[1][j] = map[i][j];
            }
            roads.add(road[0]);
            roads.add(road[1]);
        }

        int[] diff = new int[N];
        int roadCnt = 0;

        for (int[] road : roads) {
            for (int i = 1; i < N; i++)
                diff[i] = road[i] - road[i-1];

            if (isPassed(diff))
                roadCnt++;
        }
        System.out.println(roadCnt);
    }

    static boolean isPassed(int[] diff) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (diff[i] == 0) {
                cnt++;
                continue;
            }
            if (diff[i] > 1 || diff[i] < -1) return false;

            if (diff[i] == 1) {
                if (cnt < L) return false;
                cnt = 1;
            }
            if (diff[i] == -1) {
                cnt = 1;
                while (cnt < L) {
                    i++;
                    if (i >= N || diff[i] != 0) return false;
                    cnt++;
                }
                cnt = 0;
            }
        }
        return true;
    }
}
