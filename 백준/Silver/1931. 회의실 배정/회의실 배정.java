import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int s = 0, e = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][1] < e) {
                s = arr[i][0];
                e = arr[i][1];
                continue;
            }
            if (arr[i][0] >= e) {
                s = arr[i][0];
                e = arr[i][1];
                ans++;
            }
        }
        System.out.println(ans);
    }
}