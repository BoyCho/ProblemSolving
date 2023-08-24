import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	static int N, max;
	static int[][] players;
	static int[] sequence;
	static boolean[] vis;
	
	public static void main(String[] args) throws IOException {
		init();
		
		sequence[3] = 1;
		vis[1] = true;
		permutation(0);
		
		System.out.println(max);
	}
	
	public static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		
		players = new int[N][10];
		sequence = new int[9];
		vis = new boolean[10];
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++)
				players[i][j] = Integer.parseInt(stk.nextToken());
		}
		max = 0;
	}
	
	public static void permutation(int L) {
		if (L == 9) {
			max = Math.max(max, getScore());
			return;
		}
		
		if (L == 3) {
			permutation(L + 1);
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			if (vis[i]) continue;
			
			vis[i] = true;
			sequence[L] = i;
			permutation(L + 1);
			vis[i] = false;
		}
	}
	
	public static int getScore() {
		int curSeq = 0;
		int score = 0;
		int outCnt = 0;
		
		for (int ining = 0; ining < N; ining++) {
			boolean[] ground = new boolean[3];
			
			while (outCnt < 3) {
				int curPlayer = sequence[curSeq];
				int curState = players[ining][curPlayer];
				
				if (curState == 0)
					outCnt++;
				else 
					score += hit(ground, curState);
				
				curSeq = (curSeq + 1) % 9;
			}
			outCnt = 0;
		}
		
		return score;
	}
	
	public static int hit(boolean[] ground, int type) {
		int score = 0;
		
		switch(type) {
		case 1:
			if (ground[2]) score++;
			ground[2] = ground[1];
			ground[1] = ground[0];
			ground[0] = true;
			break;
			
		case 2:
			for (int i = 2; i >= 1; i--) {
				if (!ground[i]) continue;
				score++;
				ground[i] = false;
			}
			if (ground[0]) {
				ground[0] = false;
				ground[2] = true;
			}
			ground[1] = true;
			break;
			
		case 3:
			for (int i = 2; i >= 0; i--) {
				if (ground[i]) score++;
				ground[i] = false;
			}
			ground[2] = true;
			break;
			
		case 4:
			for (int i = 2; i >= 0; i--) {
				if (ground[i]) score++;
				ground[i] = false;
			}
			score++;
			break;
		}
		return score;
	}
}