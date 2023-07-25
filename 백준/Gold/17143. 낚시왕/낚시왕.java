import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Queue<int[]> sharks = new LinkedList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(stk.nextToken());
		int C = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int ans = 0;
		
		int[][][] map = new int[R + 1][C + 1][3];	// 속력0, 이동 방향1, 크기2
		
		while (M-- > 0) {
			stk = new StringTokenizer(br.readLine());
			
			int[] shark = new int[5];
			for (int i = 0; i < 5; i++)
				shark[i] = Integer.parseInt(stk.nextToken());
			
			for (int i = 2; i < 5; i++)
				map[shark[0]][shark[1]][i - 2] = shark[i];
		}
		
		int[] dx = {0, -1, 1, 0, 0};	// dir : 0, 1, 2, 3, 4
		int[] dy = {0, 0, 0, 1, -1};
		int T = 0;
		
		while (T < C) {
			// 상어 잡기
			T++;
			for (int i = 1; i <= R; i++) {
				if (map[i][T][2] > 0) {	// 상어가 있는가 (크기가 > 0) 
					ans += map[i][T][2];
					for (int j = 0; j < 3; j++)
						map[i][T][j] = 0;
					break;
				}
			}
			
			// 상어 이동
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (map[i][j][2] == 0) continue;
					
					int dir = map[i][j][1];
					int move, nx = i, ny = j;
					
					if (dir <= 2) {	//위, 아래
						move = map[i][j][0] % ((R - 1) * 2);
						
						for (int k = 0; k < move; k++) {
							if (nx == 1) dir = 2;
							if (nx == R) dir = 1;
							nx += dx[dir];
						}
					}
					else {
						move = map[i][j][0] % ((C - 1) * 2);
						
						for (int k = 0; k < move; k++) {
							if (ny == 1) dir = 3;
							if (ny == C) dir = 4;
							ny += dy[dir];
						}
					}
					sharks.offer(new int[] {nx, ny, map[i][j][0], dir, map[i][j][2]});
					for (int k = 0; k < 3; k++)
						map[i][j][k] = 0;
				}
			}
			
			// 상어 서로 잡아먹기
			while (!sharks.isEmpty()) {
				int[] cur = sharks.poll();
				
				if (cur[4] < map[cur[0]][cur[1]][2]) continue;
				for (int i = 0; i < 3; i++) {
					map[cur[0]][cur[1]][i] = cur[i + 2];
				}
			}
		}
		
		System.out.println(ans);
	}
}