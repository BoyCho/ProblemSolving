import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] LIS = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = 0;
        LIS[size++] = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            int l = 0, r = size;
            int t = Integer.parseInt(st.nextToken());

            while (l < r) {
                int mid = (l + r) / 2;

                if (t <= LIS[mid])
                    r = mid;
                else
                    l = mid + 1;
            }
            if (r == size) size++;
            LIS[r] = t;
        }
        System.out.println(size);
    }
}
