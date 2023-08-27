import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static char[][][] map;
	static boolean[][][] vis;
	static int N;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		init();
		int[] ans = BFS();
		System.out.println(ans[0] + " " + ans[1]);
	}
	
	public static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		
		map = new char[2][N][N];
		vis = new boolean[2][N][N];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[0][i][j] = input.charAt(j);
				map[1][i][j] = input.charAt(j);
				
				if (map[1][i][j] == 'G') map[1][i][j] = 'R';
			}
		}
	}
	
	public static int[] BFS() {
		int[] ans = new int[2];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 2; k++) {
					if (vis[k][i][j]) continue;
					
					ans[k]++;
					Queue<int[]> Q = new ArrayDeque<>();
					
					Q.offer(new int[] {i, j});
					vis[k][i][j] = true;
					
					while (!Q.isEmpty()) {
						int[] cur = Q.poll();
						
						for (int dir = 0; dir < 4; dir++) {
							int nx = cur[0] + dx[dir];
							int ny = cur[1] + dy[dir];
							
							if (nx < 0 || ny < 0 || nx >= N || ny >= N || vis[k][nx][ny]) continue;
							if (map[k][nx][ny] != map[k][cur[0]][cur[1]]) continue;
							
							Q.offer(new int[] {nx, ny});
							vis[k][nx][ny] = true;
						}
					}
				}
			}
		}
		return ans;
	}
}
