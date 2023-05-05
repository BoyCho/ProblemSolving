import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N+1];
        tk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            A[i] = Integer.parseInt(tk.nextToken());

        int[] B = new int[N+1];
        tk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            B[Integer.parseInt(tk.nextToken())] = i;

        int[] d = new int[N+1];
        int cur = 0;

        for (int i = 1; i <= N; i++) {
            int idx = lowerBound(B[A[i]], d, cur);
            d[idx] = B[A[i]];
            if (idx == cur) cur++;
        }
        System.out.println(cur);
    }

    static int lowerBound(int t, int[] arr, int en) {
        int st = 0;
        while (st < en) {
            int mid = (st + en) / 2;

            if (arr[mid] >= t)
                en = mid;
            else
                st = mid + 1;
        }
        return en;
    }
}