import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();

        while (n-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            if (num > 0) plus.add(num);
            else minus.add(num * -1);
        }

        Collections.sort(plus);
        Collections.sort(minus);

        int min = Integer.MAX_VALUE;
        int[] res = new int[2];

        for (int P : plus) {
            int l = 0, r = minus.size();
            while (l < r) {
                int mid = (l + r) / 2;
                if (minus.get(mid) > P)
                    r = mid;
                else
                    l = mid + 1;
            }
            r--;
            if (r >= 0 && Math.abs(P - minus.get(r)) < min) {
                min = Math.abs(P - minus.get(r));
                res[0] = minus.get(r) * -1; res[1] = P;
            }
            if (++r < minus.size() && Math.abs(P - minus.get(r)) < min) {
                min = Math.abs(P - minus.get(r));
                res[0] = minus.get(r) * -1; res[1] = P;
            }
        }
        if (plus.size() >= 2 && plus.get(0) + plus.get(1) < min) {
            min = plus.get(0) + plus.get(1);
            res[0] = plus.get(0); res[1] = plus.get(1);
        }
        if (minus.size() >= 2 && minus.get(0) + minus.get(1) < min) {
            res[0] = minus.get(1) * -1; res[1] = minus.get(0) * -1;
        }
        System.out.println(res[0] + " " + res[1]);
    }
}
