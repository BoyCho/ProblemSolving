import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	static int N;
	static int[][] map;
	static int[][][] d;
	
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		init();
		move();
		System.out.println(d[0][N][N] + d[1][N][N] + d[2][N][N]);
	}
	
	public static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				map[i][j] = Integer.parseInt(stk.nextToken());
		}
		
		d = new int[3][N + 1][N + 1];
		d[0][1][2] = 1;
	}
	
	public static void move() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1) continue;
				
				if (map[i][j - 1] != 1)
					d[0][i][j] += d[0][i][j - 1] + d[2][i][j - 1];
				
				if (map[i - 1][j] != 1)
					d[1][i][j] += d[1][i - 1][j] + d[2][i - 1][j];
				
				if (map[i][j - 1] != 1 && map[i - 1][j] != 1 && map[i - 1][j - 1] != 1)
					d[2][i][j] += d[0][i - 1][j - 1] + d[1][i - 1][j - 1] + d[2][i - 1][j - 1];
			}
		}
	}
}
