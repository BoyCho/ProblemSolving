import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	static int[][] lab;
	static int[][] vis;
	static int N, M, cnt, ans;
	
	static List<int[]> space, birus;
	static int[] pick;
	
	public static void main(String[] args) throws IOException {
		init();
		DFS(0, 0);
		System.out.println(ans);
	}
	
	static void init() throws IOException {
		stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		lab = new int[N][M];
		vis = new int[N][M];
		
		space = new ArrayList<>();
		birus = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(stk.nextToken());
				
				if (lab[i][j] == 0)
					space.add(new int[] {i, j});
				if (lab[i][j] == 2)
					birus.add(new int[] {i, j});
			}
		}
		pick = new int[3];
		cnt = 0;
		ans = 0;
	}
	
	static void DFS(int L, int st) {
		if (L == 3) {
			ans = Math.max(ans, BFS());
			return;
		}
		
		for (int i = st; i < space.size(); i++) {
			pick[L] = i;
			DFS(L + 1, i + 1);
		}
	}
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static int BFS() {
		cnt++;
		int result = 0;
		
		for (int cur : pick) 
			lab[space.get(cur)[0]][space.get(cur)[1]] = 1;
		
		Queue<int[]> Q = new ArrayDeque<>();
		for (int[] b : birus) {
			Q.offer(new int[] {b[0], b[1]});
			vis[b[0]][b[1]] = cnt;
		}
		
		while (!Q.isEmpty()) {
			int[] cur = Q.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if (lab[nx][ny] == 1 || vis[nx][ny] == cnt) continue;
				
				Q.offer(new int[] {nx, ny});
				vis[nx][ny] = cnt;
				result++;
			}
		}
		
		for (int cur : pick) 
			lab[space.get(cur)[0]][space.get(cur)[1]] = 0;

		return space.size() - result - 3;
	}
}
