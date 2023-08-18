import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	static int[][] map;
	static int N, M;
	
	static Queue<int[]> Q;
	static int[][] vis;

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		map = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = input.charAt(j - 1) - '0';
			}
		}

		vis = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				vis[i][j] = Integer.MAX_VALUE;
			}
		}
		
		Q = new ArrayDeque<>();
		Q.offer(new int[] {1, 1});
		vis[1][1] = 0;
		
		while(!Q.isEmpty() && vis[N][M] == Integer.MAX_VALUE) {
			int[] cur = Q.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
				if (vis[cur[0]][cur[1]] + 1 >= vis[nx][ny] || map[nx][ny] == 0) continue;
				
				Q.offer(new int[] {nx, ny});
				vis[nx][ny] = vis[cur[0]][cur[1]] + 1;
			}
		}
		System.out.println(vis[N][M] + 1);
	}
}