import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());

        boolean[][] arr = new boolean[101][101];

        while (N-- > 0) {
            stk = new StringTokenizer(br.readLine());

            int st1 = Integer.parseInt(stk.nextToken());
            int st2 = Integer.parseInt(stk.nextToken());

            for (int i = st1 + 1; i <= st1 + 10; i++) {
                for (int j = st2 + 1; j <= st2 + 10; j++) {
                    arr[i][j] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (arr[i][j]) ans++;
            }
        }
        System.out.println(ans);
    }
}