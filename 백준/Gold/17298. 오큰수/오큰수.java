import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer stk;

    static int N;
    static int[] arr, ans;
    static Deque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        ans = new int[N];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peekLast()) {
                stack.pollLast();
            }
            if (stack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stack.peekLast();
            stack.addLast(arr[i]);
        }
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}