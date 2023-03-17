import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuffer sb = new StringBuffer();
    static List<String> arr = new ArrayList<>();
    static int L, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens())
            arr.add(st.nextToken());

        Collections.sort(arr);

        BT(0, "");
        System.out.println(sb);
    }

    static void BT(int k, String str) {
        if (str.length() == L) {
            check(str);
            return;
        }
        if (k == arr.size()) return;

        BT(k + 1, str + arr.get(k));
        BT(k + 1, str);
    }

    static void check(String str) {
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' ||
                    str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                cnt1++;
                continue;
            } cnt2++;
        }
        if (cnt1 >= 1 && cnt2 >= 2)
            sb.append(str).append("\n");
    }
}
