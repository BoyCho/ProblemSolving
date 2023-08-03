import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
                }
            }

            int max = 0;
            for (int i = M; i <= N; i++) {
                for (int j = M; j <= N; j++) {
                    max = Math.max(max, arr[i][j] - arr[i - M][j] - arr[i][j - M] + arr[i - M][j - M]);
                }
            }
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
