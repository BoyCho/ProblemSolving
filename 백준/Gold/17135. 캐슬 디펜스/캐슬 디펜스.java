import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	static int N, M, D, max = 0;
	static int[][] map, playMap;
	
	static int[] archers, pickedArchers;
	static boolean[][][] archerAttackArr;
	
	static Queue<int[]> killed;
	
	static int[] dx = {0, -1, 0};
	static int[] dy = {-1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		init();
		comb(0, 0);
		print();
	}
	
	public static void init() throws IOException {
		stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		D = Integer.parseInt(stk.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		pickedArchers = new int[3];
	}
	
	public static void comb(int L, int st) {
		if (L == 3) {
			play();
			return;
		}
		
		for (int i = st; i < M; i++) {
			pickedArchers[L] = i;
			comb(L + 1, i + 1);
		}
	}
	
	public static void play() {
		playMap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				playMap[i][j] = map[i][j];
			}
		}
		
		int cnt = 0;
		for (int i = N; i > 0; i--) {
			killed = new ArrayDeque<>();
			
			for (int arch : pickedArchers) 
				shoot(i, arch);
			
			while(!killed.isEmpty()) {
				int[] cur = killed.poll();
				
				if (playMap[cur[0]][cur[1]] == 0) continue;
				
				playMap[cur[0]][cur[1]] = 0;
				cnt++;
			}
		}
		max = Math.max(max, cnt);
	}

	public static void shoot(int x, int archer) {
		Queue<int[]> Q = new ArrayDeque<>();
		boolean[][] vis = new boolean[N][M];
		
		Q.offer(new int[] {x, archer});
		int L = 0;
		
		while (!Q.isEmpty()) {
			int len = Q.size();
			while (len-- > 0) {
				int[] cur = Q.poll();
				
				for (int dir = 0; dir < 3; dir++) {
					int nx = cur[0] + dx[dir];
					int ny = cur[1] + dy[dir];
					
					if (nx < 0 || ny < 0 || nx >= x || ny >= M || vis[nx][ny]) continue;
					
					if (playMap[nx][ny] == 1) {
						killed.offer(new int[] {nx, ny});
						return;
					}
					
					Q.offer(new int[] {nx, ny});
					vis[nx][ny] = true;
				}
			}
			if (++L == D) return;
		}
		return;
	}
	
	public static void print() {
		System.out.println(max);
	}
}
