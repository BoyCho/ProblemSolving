import java.io.*;

public class Main {

    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int l = 0, r = 1000000001;
        while (l < r) {
            int mid = (l + r) / 2;

            if (getNums(mid) >= k)
                r = mid;
            else
                l = mid + 1;
        }
        System.out.println(r);
    }

    static int getNums(int num) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (n / i == 0) break;
            cnt += Math.min(num / i, n);
        }
        return cnt;
    }
}
