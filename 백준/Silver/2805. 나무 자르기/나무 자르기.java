import java.util.StringTokenizer;
import java.io.*;

public class Main {

    static int n, m;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        trees = new int[n];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        int l = 0, r = max + 1;
        while (l < r) {
            int mid = (l + r) / 2;

            if (getTrees(mid) < m)
                r = mid;
            else
                l = mid + 1;
        }
        System.out.println(r - 1);
    }

    static long getTrees(int len) {
        long res = 0;
        for (int tree: trees) {
            if (tree <= len) continue;
            res += tree - len;
        }
        return res;
    }
}