import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] d = new int[41][3];

        for (int i = 0; i <= 40; i++) {
            if (i == 0) {
                d[i][0] = 0;
                d[i][1] = 1;
                continue;
            }
            if (i == 1) {
                d[i][0] = 1;
                d[i][2] = 1;
                continue;
            }
            d[i][0] = d[i-2][0] + d[i-1][0];
            d[i][1] = d[i-2][1] + d[i-1][1];
            d[i][2] = d[i-2][2] + d[i-1][2];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T, N;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            sb.append(d[N][1]).append(" ").append(d[N][2]).append("\n");
        }
        System.out.print(sb);
    }
}
