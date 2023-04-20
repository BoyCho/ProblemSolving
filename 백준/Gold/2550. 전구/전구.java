import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] switches = new int[n];
        int[] bulbs = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            switches[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            bulbs[Integer.parseInt(st.nextToken())] = i;

        int[] LIS_trace = new int[n];
        int[] LIS = new int[n];
        int size = 0;

        // LIS 기록 획득
        for (int i = 0; i < n; i++) {
            int l = 0, r = size;
            while (l < r) {
                int mid = (l + r) / 2;

                if (bulbs[switches[i]] < bulbs[LIS[mid]])
                    r = mid;
                else
                    l = mid + 1;
            }
            LIS[r] = switches[i];
            LIS_trace[i] = r;
            if (r == size) size++;
        }

        // LIS 추적
        List<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (LIS_trace[i] == size - 1) {
                ans.add(switches[i]);
                size--;
            }
        }
        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append("\n");
        for (int num : ans)
            sb.append(num).append(" ");
        System.out.println(sb);
    }
}
