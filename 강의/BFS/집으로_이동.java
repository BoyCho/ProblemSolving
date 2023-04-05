import java.util.*;

class 집으로_이동 {
    public int solution(int[] pool, int a, int b, int home){
        int[] board = new int[10001];

        for (int p : pool) board[p] = -1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int cur = p[0], bUsed = p[1];

            if (cur + a < 10000 && board[cur + a] != -1) {
                if (board[cur + a] == 0 || board[cur + a] > board[cur]) {
                    q.offer(new int[]{cur + a, 0});
                    board[cur + a] = board[cur] + 1;
                }
            }
            if (bUsed != 1 && cur - b >= 0 && board[cur - b] != -1) {
                if (board[cur - b] == 0 || board[cur - b] > board[cur]) {
                    q.offer(new int[]{cur - b, 1});
                    board[cur - b] = board[cur] + 1;
                }
            }
            if (board[home] > 0) return board[home];
        }

        return -1;
    }

    public static void main(String[] args){
        집으로_이동 T = new 집으로_이동();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}