import java.util.*;

class 집을_짓자 {
    public int solution(int[][] board){
        int n = board.length, answer = 0;
        int[][] dist = new int[n][n];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> Q = new LinkedList<>();
        int emptyLand = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (board[i][j] != 1) continue;

                Q.add(new int[]{i, j});

                answer = Integer.MAX_VALUE;
                int L = 0;

                while (!Q.isEmpty()) {
                    int len = Q.size();
                    L++;
                    for (int k = 0; k < len; k++) {
                        int[] cur = Q.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                            if (board[nx][ny] != emptyLand) continue;

                            board[nx][ny] = emptyLand - 1;
                            dist[nx][ny] += L;
                            answer = Math.min(answer, dist[nx][ny]);

                            Q.offer(new int[]{nx, ny});
                        }
                    }
                }
                emptyLand--;
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    public static void main(String[] args){
        집을_짓자 T = new 집을_짓자();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}