import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int T;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        arr = new long[1000001];
        Arrays.fill(arr, 1);

        for (int i = 2; i <= 1000000; i++) {
            for (int j = i; j <= 1000000; j += i) {
                arr[j] += i;
            }
        }

        for (int i = 2; i <= 1000000; i++) {
            arr[i] += arr[i - 1];
        }

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            sb.append(arr[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
}