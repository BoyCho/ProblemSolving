import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;


    static PriorityQueue<int[]> jewelryForM = new PriorityQueue<>(
            (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
    static PriorityQueue<int[]> jewelryForV = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
    static int[] bags;
    static int N, K;
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(stk.nextToken());
            int V = Integer.parseInt(stk.nextToken());

            jewelryForM.offer(new int[]{M, V});
        }

        bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);
        for (int bag : bags) {
            while (!jewelryForM.isEmpty() && jewelryForM.peek()[0] <= bag) {
                jewelryForV.offer(jewelryForM.poll());
            }
            if (!jewelryForV.isEmpty()) {
                ans += jewelryForV.poll()[1];
            }
        }
        System.out.println(ans);
    }
}
