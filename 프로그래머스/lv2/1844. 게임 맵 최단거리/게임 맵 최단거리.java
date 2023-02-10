import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    static class Move {
        int x, y;

        public Move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        Queue<Move> queue = new LinkedList<>();
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};

        int n = maps.length;
        int m = maps[0].length;
        int[][] vis = new int[n][m];

        queue.add(new Move(0, 0));

        while(!queue.isEmpty()) {
            Move move = queue.poll();

            for( int i = 0; i < 4; i++) {
                int nx = move.x + dx[i];
                int ny = move.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (maps[nx][ny] == 0 || vis[nx][ny] != 0) continue;

                vis[nx][ny] = vis[move.x][move.y] + 1;
                queue.add(new Move(nx, ny));
            }
        }
        return vis[n-1][m-1] == 0 ? -1 : vis[n-1][m-1] + 1;
    }
}