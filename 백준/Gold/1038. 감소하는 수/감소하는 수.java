import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static List<Long> list = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        if (N <= 10) {
            System.out.println(N);
            return;
        } else if(N >= 1023) {
            System.out.println(-1);
            return;
        }

        for(int i=0; i<10; i++) {
            BT(i, 1);
        }

        Collections.sort(list);
        System.out.println(list.get(N));
    }

    private static void BT(long num, int idx) {
        if (idx > 10) return;

        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            BT((num * 10) + i, idx + 1);
        }
    }
}