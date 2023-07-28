import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<int[]> balloons = new ArrayDeque<>();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            balloons.addLast(new int[]{i, Integer.parseInt(stk.nextToken())});

        StringBuilder sb = new StringBuilder();
        int next = 0;

        while (!balloons.isEmpty()) {
            if (next > 0) {
                while (next-- > 1)
                    balloons.addLast(balloons.pollFirst());
            } else {
                while (next++ < 0)
                    balloons.addFirst(balloons.pollLast());
            }

            int[] cur = balloons.pollFirst();

            next = cur[1];
            sb.append(cur[0]).append(" ");
        }
        System.out.println(sb);
    }
}
