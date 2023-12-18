import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;

    static int[][] map = new int[21][21];
    static int[][][][] dp = new int[3][4][21][21];

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 19; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                if (map[j][i] == 0) continue;
                int player = map[j][i];

                dp[player][0][j][i] = dp[player][0][j - 1][i] + 1;
                dp[player][1][j][i] = dp[player][1][j][i - 1] + 1;
                dp[player][2][j][i] = dp[player][2][j - 1][i - 1] + 1;

                if (isWin(player, j, i)) return;
            }
        }

        for (int i = 1; i <= 19; i++) {
            for (int j = 19; j >= 1; j--) {
                if (map[i][j] == 0) continue;
                int player = map[i][j];

                dp[player][3][i][j] = dp[player][3][i - 1][j + 1] + 1;

                if (dp[player][3][i][j] == 5 && map[i + 1][j - 1] != player) {
                    System.out.println(player + "\n" + i + " " + j);
                    return;
                }
            }
        }
        System.out.println("0");
    }

    static boolean isWin(int player, int x, int y) {
        if (dp[player][0][x][y] == 5 && map[x + 1][y] != player) {
            System.out.println(player + "\n" + (x - 4) + " " + y);
            return true;
        }
        if (dp[player][1][x][y] == 5 && map[x][y + 1] != player) {
            System.out.println(player + "\n" + x + " " + (y - 4));
            return true;
        }
        if (dp[player][2][x][y] == 5 && map[x + 1][y + 1] != player) {
            System.out.println(player + "\n" + (x - 4) + " " + (y - 4));
            return true;
        }
        return false;
    }
}