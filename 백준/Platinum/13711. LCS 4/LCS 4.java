import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(tk.nextToken());

        int[] B = new int[N];
        int[] Index = new int[100001];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(tk.nextToken());
            Index[B[i]] = i;
        }

        Arrays.sort(B);

        int[] d = new int[N+1];
        int cur = 0;

        for (int t: A) {
            int i = rowerBound(t, B, N);
            if (B[i] != t) continue;

            int idx = rowerBound(Index[B[i]], d, cur);
            d[idx] = Index[B[i]];
            if (idx == cur) cur++;
        }
        System.out.println(cur);
    }

    static int rowerBound(int t, int[] arr, int en) {
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