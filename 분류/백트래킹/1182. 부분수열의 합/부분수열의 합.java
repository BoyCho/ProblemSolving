import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> arr = new ArrayList<>();
    static int n,s, cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) arr.add(Integer.parseInt(st.nextToken()));

        BT(0, 0);

        if (s == 0) cnt--;
        System.out.println(cnt);
    }

    static void BT(int k, int sum) {
        if (k == n) {
            if (sum == s) cnt++;
            return;
        }
        BT(k + 1, sum);
        BT(k + 1, sum + arr.get(k));
    }
}
