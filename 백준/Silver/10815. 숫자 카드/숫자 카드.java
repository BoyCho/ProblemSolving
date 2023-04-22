import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            int l = 0, r = n;

            while (l < r) {
                int mid = (l + r) / 2;

                if (num <= cards[mid])
                    r = mid;
                else
                    l = mid + 1;
            }
            if (r < n && cards[r] == num)
                sb.append(1).append(" ");
            else
                sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}
