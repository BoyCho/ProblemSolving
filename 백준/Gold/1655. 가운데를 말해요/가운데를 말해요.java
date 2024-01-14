import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Integer> maxPQ, minPQ;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        maxPQ = new PriorityQueue<>((i1, i2) -> i2 - i1);
        minPQ = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());

            if (maxPQ.size() > minPQ.size()) minPQ.offer(cur);
            else maxPQ.offer(cur);

            if (!maxPQ.isEmpty() && !minPQ.isEmpty() &&
                maxPQ.peek() > minPQ.peek()) {
                int tmp = minPQ.poll();
                minPQ.offer(maxPQ.poll());
                maxPQ.offer(tmp);
            }
            sb.append(maxPQ.peek()).append("\n");
        }
        System.out.println(sb);
    }
}