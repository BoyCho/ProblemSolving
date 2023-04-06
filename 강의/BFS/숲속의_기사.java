import java.util.*;

class 숲속의_기사 {
    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;
        int r = board.length;
        int c = board[0].length;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] vis = new int[r][c];

        int emptyLand = -1;

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++) {
                if (board[i][j] != 4) continue;

                Queue<int[]> Q = new LinkedList<>();

                Q.offer(new int[]{i, j});
                vis[i][j] = emptyLand;

                int hee = 0, knight = 0;
                int L = 0;

                while (!Q.isEmpty()) {
                    int len = Q.size();
                    L++;
                    for (int k = 0; k < len; k++) {
                        int[] cur = Q.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];

                            if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                            if (vis[nx][ny] == emptyLand || board[nx][ny] == 1) continue;

                            if (board[nx][ny] == 2) hee = L;
                            if (board[nx][ny] == 3) knight = L;


                            Q.offer(new int[]{nx, ny});
                            vis[nx][ny] = emptyLand;
                        }
                        if (hee != 0 && knight != 0) {
                            answer = Math.min(answer, hee + knight);
                            break;
                        }
                    }
                    if (hee != 0 && knight != 0) break;
                }
                emptyLand--;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        숲속의_기사 T = new 숲속의_기사();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{  {4, 1, 0, 1, 0},
                                                    {0, 1, 0, 1, 2},
                                                    {0, 0, 3, 4, 4},
                                                    {0, 1, 0, 1, 0}}));
    }
}