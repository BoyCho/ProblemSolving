import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	static int K, W, H;
	static int[][] map;
	static boolean[][][] vis;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(BFS());
	}
	
	public static void init() throws IOException {
		K = Integer.parseInt(br.readLine());
		
		stk = new StringTokenizer(br.readLine());
		W = Integer.parseInt(stk.nextToken());
		H = Integer.parseInt(stk.nextToken());
		
		map = new int[H][W];
		vis = new boolean[K + 1][H][W];
		
		for (int i = 0; i < H; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++)
				map[i][j] = Integer.parseInt(stk.nextToken());
		}
	}
	
	public static int BFS() {
		
		if (W == 1 && H == 1) return 0;
		
		Queue<int[]> Q = new ArrayDeque<>();
		Q.offer(new int[] {0, 0, 0});
		vis[0][0][0] = true;
		
		int T = 0;
		while (!Q.isEmpty()) {
			int len = Q.size();
			while (len-- > 0) {
				int x = Q.peek()[0];
				int y = Q.peek()[1];
				int k = Q.peek()[2];
				Q.poll();
				
				for (int dir = 0; dir < 4; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					
					if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
					if (vis[k][nx][ny] || map[nx][ny] == 1) continue;
					
					if (nx == H - 1 && ny == W - 1) return T + 1;
					
					Q.offer(new int[] {nx, ny, k});
					vis[k][nx][ny] = true;
				}
				
				if (k == K) continue;
				
				for (int dir = 0; dir < 8; dir++) {
					int nx = x + hx[dir];
					int ny = y + hy[dir];
					
					if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
					if (vis[k + 1][nx][ny] || map[nx][ny] == 1) continue;
					
					if (nx == H - 1 && ny == W - 1) return T + 1;
					
					Q.offer(new int[] {nx, ny, k + 1});
					vis[k + 1][nx][ny] = true;
				}
			}
			T++;
		}
		return -1;
	}
}
