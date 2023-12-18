import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;

    static int N, d, k, c;
    static int cur = 0, max = 0;
    static int[] dish, sushi;

    public static void main(String[] args) throws IOException {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        d = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());

        int dishSize = N + k;
        dish = new int[dishSize];
        sushi = new int[d + 1];

        for (int i = 0; i < N; i++)
            dish[i] = Integer.parseInt(br.readLine());
        for (int i = N; i < dishSize; i++)
            dish[i] = dish[i - N];
        for (int i = 0; i < k; i++) {
            if (++sushi[dish[i]] == 1)
                cur++;
        }
        max = (sushi[c] == 0) ? cur + 1 : cur;

        int st = 0, en = k - 1;
        while (en + 1 < dishSize) {
            if (++sushi[dish[++en]] == 1)
                cur++;
            if (--sushi[dish[st++]] == 0)
                cur--;
            max = (sushi[c] == 0) ? Math.max(max, cur + 1) : Math.max(max, cur);
        }
        System.out.println(max);
    }
}