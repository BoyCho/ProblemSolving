import java.util.*;
class 방향_바꾸기 {
    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        PriorityQueue<int[]> Q = new PriorityQueue<>((q1, q2) -> q1[2] - q2[2]);
        int[][] cost = new int[n][m];

        for (int[] c : cost) Arrays.fill(c, Integer.MAX_VALUE);

        int[] dx = {0,0,0,1,-1};
        int[] dy = {0,1,-1,0,0};

        Q.offer(new int[]{0,0,0});
        cost[0][0] = 0;

        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            if (cur[2] != cost[cur[0]][cur[1]]) continue;

            for (int dir = 1; dir <= 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                int changeCnt = cur[2];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[cur[0]][cur[1]] != dir) changeCnt++;
                if (changeCnt >= cost[nx][ny]) continue;

                Q.offer(new int[]{nx, ny, changeCnt});
                cost[nx][ny] = changeCnt;
            }
        }
        return cost[n-1][m-1];
    }

    public static void main(String[] args){
        방향_바꾸기 T = new 방향_바꾸기();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}