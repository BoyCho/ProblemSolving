import java.util.*;

public class 좌석번호 {
    public int[] solution(int c, int r, int k) {
        // 좌석: [a][b] -> (b + 1, c - a - 1)
        // 시작: [r -1][0] (1번쨰)
        if (c * r < k) return new int[]{0, 0};

        boolean[][] vis = new boolean[r][c];
        int[] xy = new int[]{r - 1, 0};
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int cnt = 1, dir = 0;

        vis[xy[0]][xy[1]] = true;

        while (cnt < k) {
            int nx = xy[0] + dx[dir];
            int ny = xy[1] + dy[dir];

            if (nx < 0 || ny < 0 || nx >= r || ny >= c || vis[nx][ny] == true) {
                dir = (dir + 1) % 4;
                continue;
            }
            vis[nx][ny] = true;
            xy[0] = nx; xy[1] = ny;
            cnt++;
        }
        return new int[]{xy[1] + 1, c - xy[0] - 1};
    }

    public static void main(String[] args){
        좌석번호 T = new 좌석번호();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
