import java.io.*;
import java.util.*;

public class Main {

	static int[][] arr;
	static int N, M, R;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	static Queue<Integer> Q = new ArrayDeque<>();
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		R = Integer.parseInt(stk.nextToken());
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		int cnt = N > M ? M / 2 : N / 2;
			
		for (int i = 0; i < cnt; i++) {
			rotate(i, i, true);
			for (int j = 0; j < R; j++) Q.offer(Q.poll());
			rotate(i, i, false);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void rotate(int floorX, int floorY, boolean type) {
		
		int x = floorX;
		int y = floorY;
		
		for (int dir = 0; dir < 4; dir++) {
			while (true) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if (nx < floorX || ny < floorY || nx >= N - floorX || ny >= M - floorY) break;
				
				if (type) Q.offer(arr[x][y]);
				else arr[x][y] = Q.poll();
				
				x = nx; 
				y = ny;
			}
		}
	}
}
