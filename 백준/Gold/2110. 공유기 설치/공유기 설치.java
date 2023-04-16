import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] h;
    static int n, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        h = new int[n];

        for (int i = 0; i < n; i++)
            h[i] = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        Arrays.sort(h);

        int l = 0, r = h[n-1] - h[0] + 1;

        while (l < r) {
            int mid = (l + r) / 2;

            if (hCnt(mid) < c)
                r = mid;
            else
                l = mid + 1;
        }
        System.out.println(r - 1);
    }

    static int hCnt(int len) {
        int st = h[0], cnt = 1;
        for (int i = 1; i < n; i++) {
            int t = h[i];

            if (t - st < len) continue;
            st = t;
            cnt++;
        }
        return cnt;
    }
}
