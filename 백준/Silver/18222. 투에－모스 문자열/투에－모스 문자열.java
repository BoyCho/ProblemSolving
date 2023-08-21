import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k = 1;

    public static void main(String[] args) throws IOException {
        DFS(Long.parseLong(br.readLine()) - 1);
    }

    public static void DFS(long n) {
        if (n <= 1) {
            if (n == 0) k = (k + 1) % 2;
            System.out.println(k);
            return;
        }

        for (int i = 1; i <= 61; i++) {
            if (n < Math.pow(2, i)) {
                n -= (long)Math.pow(2, i - 1);
                break;
            }
        }
        k = (k + 1) % 2;
        DFS(n);
    }
}