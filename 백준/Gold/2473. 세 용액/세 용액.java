import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        long[] arr = new long[N];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Long.parseLong(stk.nextToken());

        long min = Long.MAX_VALUE;
        long[] ans = new long[3];

        Arrays.sort(arr);
        for (int st = 0; st < N - 2; st++) {
            int mid = st + 1;
            int en = N - 1;

            while (mid < en) {
                long sum = arr[st] + arr[mid] + arr[en];
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    ans = new long[]{arr[st], arr[mid], arr[en]};
                }
                if (sum == 0) break;
                if (sum < 0) mid++;
                else en--;
            }
        }
        Arrays.sort(ans);
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}
