import java.util.*;
class 미로의_최단거리_통로 {
    public int solution(int[][] board){
        Queue<int[]> q = new LinkedList<>();

        int[][] dist = new int [7][7];
        for (int[] tmp : dist) Arrays.fill(tmp, -1);

        q.add(new int[]{0,0});
        dist[0][0] = 0;

        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};

        while (!q.isEmpty() && dist[6][6] == -1) {
            int[] cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || ny < 0 || nx >= 7 || ny >= 7 || board[nx][ny] == 1) continue;
                if (dist[nx][ny] != -1 && dist[nx][ny] < dist[cur[0]][cur[1]] + 1) continue;

                q.offer(new int[]{nx,ny});
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
            }
        }
        return dist[6][6];
    }

    public static void main(String[] args){
        미로의_최단거리_통로 T = new 미로의_최단거리_통로();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
    }
}