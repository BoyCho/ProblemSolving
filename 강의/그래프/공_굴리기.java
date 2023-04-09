import java.util.*;
class 공_굴리기 {
    public int solution(int[][] board, int[] s, int[] e){
        int n = board.length;
        int m = board[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((q1, q2) -> q1[2] - q2[2]);
        int[][] cost = new int[n][m];

        for (int[] c : cost) Arrays.fill(c, Integer.MAX_VALUE);

        pq.offer(new int[]{s[0],s[1],0});
        cost[s[0]][s[1]] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[2] != cost[cur[0]][cur[1]]) continue;

            for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}){
                int nx = cur[0];
                int ny = cur[1];
                int cnt = cur[2];

                while(nx>= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0){
                    nx += dir[0];
                    ny += dir[1];
                    cnt ++;
                }

                nx -= dir[0];
                ny -= dir[1];
                if (--cnt >= cost[nx][ny]) continue;

                cost[nx][ny] = cnt;
                pq.add(new int[]{nx, ny, cnt});
            }
        }
        return cost[e[0]][e[1]] == Integer.MAX_VALUE ? -1 : cost[e[0]][e[1]];
    }
    public static void main(String[] args){
        공_굴리기 T = new 공_굴리기();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}

