import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	
	static boolean[][] vis = new boolean[6][6];
	static int[][] team = new int[6][3];
	static int result;
	
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 4; i++) {
			
			result = 0;
			if (init()) BT(0, 1);
			
			sb.append(result).append(" ");
		}
		System.out.println(sb);
	}
	
	public static boolean init() throws IOException {
		stk = new StringTokenizer(br.readLine());
		
		int win = 0, draw = 0, lose = 0;
		
		for (int j = 0; j < 6; j++) {
			for (int k = 0; k < 3; k++)
				team[j][k] = Integer.parseInt(stk.nextToken());
			win += team[j][0];
			draw += team[j][1];
			lose += team[j][2];
		}
		if (win != lose || win + draw + lose != 30) return false;
		return true;
	}
	
	public static void BT(int a, int b_) {
		if (result == 1) return;
		
		if (a == 6) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (team[i][j] != 0) return;
				}
			}
			result = 1;
			return;
		}
		
		if (b_ == 6) {
			BT(a + 1, a + 2);
			return;
		}
		
		for (int b = b_; b < 6; b++) {
			if (vis[a][b]) continue;
			
			
			for (int[] type : new int[][] {{0, 2}, {1, 1}, {2, 0}}) {
				int t1 = type[0];
				int t2 = type[1];
				
				if (team[a][t1] <= 0 || team[b][t2] <= 0) continue;
				
				team[a][t1]--;
				team[b][t2]--;
				vis[a][b] = vis[b][a] = true;
				BT(a, b + 1);
				vis[a][b] = vis[b][a] = false;
				team[a][t1]++;
				team[b][t2]++;
			}
		}
	}
}
