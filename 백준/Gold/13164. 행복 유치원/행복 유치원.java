import java.io.*;
import java.util.*;

public class Main {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        int[] children = new int[N];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            children[i] = Integer.parseInt(stk.nextToken());

        List<Integer> diff = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < N - 1; i++) {
            int n = children[i + 1] - children[i];
            sum += n;
            diff.add(n);
        }

        Collections.sort(diff);
        for (int i = diff.size() - 1; i >= 0 && K > 1; i--, K--) {
            sum -= diff.get(i);
        }
        System.out.println(sum);
    }
}
