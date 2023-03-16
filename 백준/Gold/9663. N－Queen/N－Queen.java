import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] isUsed1 = new boolean[14];  // y
    static boolean[] isUsed2 = new boolean[27]; // x + y
    static boolean[] isUsed3 = new boolean[27]; // x - y + (n - 1) : n - 1 은 음수 인덱싱 피하는 용도
    static int n, cnt = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        BT(0);
        System.out.println(cnt);
    }

    static void BT(int k) {
        if (k == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isUsed1[i] || isUsed2[i + k] || isUsed3[k - i + n - 1]) continue;
            isUsed1[i] = isUsed2[i + k] = isUsed3[k - i + n - 1] = true;
            BT(k + 1);
            isUsed1[i] = isUsed2[i + k] = isUsed3[k - i + n - 1] = false;
        }
    }
}