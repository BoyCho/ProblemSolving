import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int[][][] map;
	static int[][] order;
	static int N, M, m;
	
	static Queue<int[]> cloud = new ArrayDeque<>();
	static Queue<int[]> bugTarget = new ArrayDeque<>();
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	public static void main(String[] args) throws IOException {
		init();
		for (m = 1; m <= M; m++) {
			rain(order[0][m], order[1][m]);
			waterCopyBug();
			makeCloud();
		}
		checkSum();
	}
	
	public static void init() throws IOException {
		stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		map = new int[2][N][N];
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[0][i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		order = new int[2][M + 1];
		for (int i = 1; i <= M; i++) {
			stk = new StringTokenizer(br.readLine());
			
			order[0][i] = Integer.parseInt(stk.nextToken());
			order[1][i] = Integer.parseInt(stk.nextToken());
		}
		
		for (int i = 0; i < 2; i++) {
			cloud.offer(new int[] {N - 1, i});
			cloud.offer(new int[] {N - 2, i});
		}
	}
	
	public static void rain(int d, int s) {
		while (!cloud.isEmpty()) {
			int[] cur = cloud.poll();
			
			int nx = cur[0] + s * dx[d];
			int ny = cur[1] + s * dy[d];

			nx %= N;
			ny %= N;
			
			nx = nx < 0 ? N + nx : nx;
			ny = ny < 0 ? N + ny : ny;
			
			map[0][nx][ny]++;
			map[1][nx][ny] = m;
			bugTarget.offer(new int[] {nx, ny});
		}
	}
	
	public static void waterCopyBug() {
		while (!bugTarget.isEmpty()) {
			int[] cur = bugTarget.poll();
			
			for (int dir = 2; dir <= 8; dir += 2) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[0][nx][ny] == 0) continue;
				map[0][cur[0]][cur[1]]++;
			}
		}
	}

	public static void makeCloud() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[0][i][j] < 2 || map[1][i][j] == m) continue;
				map[0][i][j] -= 2;
				cloud.offer(new int[] {i, j});
			}
		}
	}
	
	public static void checkSum() {
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[0][i][j];
			}
		}
		System.out.println(sum);
	}
}
