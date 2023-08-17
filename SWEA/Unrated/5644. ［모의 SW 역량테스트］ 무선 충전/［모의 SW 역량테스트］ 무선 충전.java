import java.util.*;
import java.io.*;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	static int T, M, A, sum;
	static int[] userA, userB, bcPower;
	static List<Integer>[][] BC;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			init();
			move();
			print(tc);
		}
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		stk = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(stk.nextToken());
		A = Integer.parseInt(stk.nextToken());
		
		userA = new int[M];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			userA[i] = Integer.parseInt(stk.nextToken());
		
		userB = new int[M];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			userB[i] = Integer.parseInt(stk.nextToken());
		
		BC = new ArrayList[11][11];
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++)
				BC[i][j] = new ArrayList<Integer>();
		}
		
		bcPower = new int[A + 1];
		for (int i = 1; i <= A; i++) {
			
			stk = new StringTokenizer(br.readLine());
			
			int apX = Integer.parseInt(stk.nextToken());
			int apY = Integer.parseInt(stk.nextToken());
			int apC = Integer.parseInt(stk.nextToken());
			bcPower[i] = Integer.parseInt(stk.nextToken());
			
			setBC(apY, apX, apC, i);

			
		}
		sum = 0;
	}
	
	public static int[] dx = {0, -1, 0, 1, 0};
	public static int[] dy = {0, 0, 1, 0, -1};
	
	public static void setBC(int x, int y, int c, int num) {
		Queue<int[]> Q = new ArrayDeque<>();
		boolean[][] vis = new boolean[11][11];
		
		Q.offer(new int[] {x, y});
		BC[x][y].add(num);
		
		vis[x][y] = true;
		int L = 0;
		
		while (!Q.isEmpty()) {
			int len = Q.size();
			while (len-- > 0) {
				int[] cur = Q.poll();
				
				for (int dir = 1; dir <= 4; dir++) {
					int nx = cur[0] + dx[dir];
					int ny = cur[1] + dy[dir];
					
					if (nx < 1 || ny < 1 || nx > 10 || ny > 10 || vis[nx][ny]) continue;
					
					Q.add(new int[] {nx ,ny});
					BC[nx][ny].add(num);
					
					vis[nx][ny] = true;
				}
			}
			if (++L == c) return;
		}
	}
	
	public static void move() {
		int ax = 1, ay = 1;
		int bx = 10, by = 10;
		
		charge(ax, ay, bx, by);
		
		for (int i = 0; i < M; i++) {
			int nax = ax + dx[userA[i]];
			int nay = ay + dy[userA[i]];
			
			int nbx = bx + dx[userB[i]];
			int nby = by + dy[userB[i]];
			
			charge(nax, nay, nbx, nby);
			
			ax = nax; ay = nay;
			bx = nbx; by = nby;
		}
	}
	
	public static void charge(int ax, int ay, int bx, int by) {
		int max = 0;
		
		for (int a : BC[ax][ay]) {
			for (int b : BC[bx][by]) {
				if (a == b) max = Math.max(max, bcPower[a]);
				else max = Math.max(max, bcPower[a] + bcPower[b]);
			}
		}
		
		if (BC[ax][ay].size() == 0) {
			for (int b : BC[bx][by])
				max = Math.max(max, bcPower[b]);
		}
		
		if (BC[bx][by].size() == 0) {
			for (int a : BC[ax][ay])
				max = Math.max(max, bcPower[a]);
		}
		sum += max;
	}
	
	public static void print(int tc) {
		sb.append("#").append(tc).append(" ").append(sum).append("\n");
	}
}
