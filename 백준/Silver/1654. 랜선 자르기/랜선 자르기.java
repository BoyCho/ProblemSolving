import java.util.*;
import java.io.*;

public class Main {

    static int k, n;
    static int[] lan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        lan = new int[k];
        for (int i = 0; i < k; i++)
            lan[i] = Integer.parseInt(br.readLine());
        Arrays.sort(lan);

        long l = 1, r = (long) lan[k-1] + 1;
        while (l < r) {
            long mid = (l + r) / 2;
            if (getNums(mid) < n)
                r = mid;
            else
                l = mid + 1;
        }
        System.out.println(r - 1);
    }

    static int getNums(long len) {
        int cnt = 0;
        for (int l : lan)
            cnt += l / len;
        return cnt;
    }
}