import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int[] arr = new int[N];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(stk.nextToken());

        Arrays.sort(arr);
        int st = 0, en = N - 1;
        int[] ans = new int[]{arr[st], arr[en]};

        while (st < en) {
            if (Math.abs(arr[st] + arr[en]) < Math.abs(ans[0] + ans[1])) {
                ans[0] = arr[st];
                ans[1] = arr[en];
            }

            if (Math.abs(arr[st] + arr[en - 1]) < Math.abs(arr[st + 1] + arr[en])) en--;
            else st++;
        }
        System.out.println(ans[0] + " " + ans[1]);
    }
}
