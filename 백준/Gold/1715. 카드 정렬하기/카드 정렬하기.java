import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static PriorityQueue<Integer> PQ = new PriorityQueue<>();
    static int N, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++)
            PQ.add(Integer.parseInt(br.readLine()));
        ans = 0;

        while (PQ.size() > 1) {
            int cur1 = PQ.poll();
            int cur2 = PQ.poll();
            ans += cur1 + cur2;
            PQ.add(cur1 + cur2);
        }
        System.out.println(ans);
    }
}
