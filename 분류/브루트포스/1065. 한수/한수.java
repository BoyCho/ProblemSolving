import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int cnt = 99;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n < 100) cnt = n;

        for (int i = 100; i <= n; i++) {
            parse(Integer.toString(i));
        }
        System.out.println(cnt);
    }

    static void parse(String n) {
        int p = n.charAt(1) - n.charAt(0);
        for (int i = 2; i < n.length(); i++) {
            if (n.charAt(i) - n.charAt(i-1) != p) return;
        }
        cnt++;;
    }
}
