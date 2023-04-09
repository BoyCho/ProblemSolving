import java.util.*;
class 벽_허물기 {
    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        PriorityQueue<int[]> Q = new PriorityQueue<>((q1, q2) -> q1[2] - q2[2]);
        int[][] cost = new int[n][m];

        for (int[] c : cost) Arrays.fill(c, Integer.MAX_VALUE);

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        Q.offer(new int[]{0,0,0});
        cost[0][0] = 0;

        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            if (cur[2] != cost[cur[0]][cur[1]]) continue;

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                int nBomb = cur[2];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[nx][ny] == 1) nBomb++;
                if (nBomb >= cost[nx][ny]) continue;

                Q.offer(new int[]{nx, ny, nBomb});
                cost[nx][ny] = nBomb;
            }
        }
        return cost[n-1][m-1];
    }

    public static void main(String[] args){
        벽_허물기 T = new 벽_허물기();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}