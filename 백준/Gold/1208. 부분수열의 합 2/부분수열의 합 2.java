import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;

    static int N, S;
    static int[] arr;
    static long ans = 0;
    static List<Integer> leftL = new ArrayList<>();
    static List<Integer> rightL = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        S = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        getSum(0, 0, N / 2, leftL);
        getSum(0, N / 2, N, rightL);

        Collections.sort(leftL);
        Collections.sort(rightL);

        int curL = 0, curR = rightL.size() - 1;
        while (curL < leftL.size() && curR >= 0) {
            int curSum = leftL.get(curL) + rightL.get(curR);

            if (curSum == S){
                int prevL = leftL.get(curL), prevR = rightL.get(curR);
                long cntL = 0, cntR = 0;

                while (curL < leftL.size() && prevL == leftL.get(curL)) {
                    curL++;
                    cntL++;
                }
                while (curR >= 0 && prevR == rightL.get(curR)) {
                    curR--;
                    cntR++;
                }
                ans += cntL * cntR;

            } else if (curSum < S) {
                curL++;
            } else {
                curR--;
            }
        }
        if (S == 0) ans -= 1;
        System.out.println(ans);
    }

    static void getSum(int sum, int st, int en, List<Integer> list) {
        if (st == en) {
            list.add(sum);
            return;
        }
        getSum(sum, st + 1, en, list);
        getSum(sum + arr[st], st + 1, en, list);
    }
}